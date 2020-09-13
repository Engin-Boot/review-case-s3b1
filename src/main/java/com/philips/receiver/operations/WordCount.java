package com.philips.receiver.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public List<String> generateListOfWords(){
		
		String line;
		String[] words;
		List<String> wordList = new ArrayList<String>();
		try{
			while((line = reader.readLine()) != null){
				line = line.trim();
				words = line.split(" ");
				for(String word : words)
				{
		        	if(word != null && (!word.isEmpty()))
		        	{   
		        		word = word.replaceAll("[^a-zA-Z0-9]", "");  
		        		wordList.add(word);
		        	}
				}		
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return wordList;
	}

	public Map<String, Integer> generateWordCount(List<String> wordList) {
		
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		
		for(String word : wordList){
			if(wordCountMap.containsKey(word)){
				count = wordCountMap.get(word);
				count += 1;
				wordCountMap.put(word, count);
			}
			else{
				wordCountMap.put(word, 1);
			}
		}
		return wordCountMap;
	}

}