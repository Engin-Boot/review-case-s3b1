package com.philips.receiver.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.philips.receiver.service.ICount;

public class WordCount implements ICount{
	
	private BufferedReader reader;
	private int count;
	
	public WordCount(BufferedReader reader){
		this.reader = reader;
		this.count = 0;
	}
	
	public void printWordCount(Map<String, Integer> map){
		
		for(Map.Entry<String, Integer> wordCount : map.entrySet()){
			System.out.println("Word = " + wordCount.getKey() + " count = " + wordCount.getValue());
		}
	}



	public Map<String, Integer> generateWordCount() {
		String line;
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		try {
			while((line = reader.readLine()) != null){
				line = line.trim();
				if(wordCountMap.containsKey(line)){
					count = wordCountMap.get(line);
					count += 1;
					wordCountMap.put(line, count);
				}
				else{
					wordCountMap.put(line, 1);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wordCountMap;
	}

}