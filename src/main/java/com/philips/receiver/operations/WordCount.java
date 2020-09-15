package com.philips.receiver.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.philips.receiver.service.ICount;

public class WordCount implements ICount{
	
	private static Logger log = Logger.getLogger(WordCount.class.getName());
	
	private BufferedReader reader;
	private int count;
	
	public WordCount(BufferedReader reader){
		this.reader = reader;
		this.count = 0;
	}
	
	public void printWordCount(Map<String, Integer> map){
		
		for(Map.Entry<String, Integer> wordCount : map.entrySet()){
			log.info("Word = " + wordCount.getKey() + " count = " + wordCount.getValue());
		}
	}

	public List<String> generateListOfWords(){
		
		String line;
		String[] words;
		List<String> wordList = new ArrayList<>();
		try{
			while((line = reader.readLine()) != null){
				line = line.trim();
				words = line.split(" ");
				for(String word : words)
				{
					word = word.replaceAll("[^a-zA-Z]", ""); 
					word = word.trim();
		        	if(!word.isEmpty())
		        	{   
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
		
		Map<String, Integer> wordCountMap = new HashMap<>();
		
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
