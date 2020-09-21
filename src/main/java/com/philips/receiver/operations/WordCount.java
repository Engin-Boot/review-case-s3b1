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
	
	public WordCount() {
		this.reader = null;
		this.count = 0;
	}
	
	public BufferedReader getReader(){
		return this.reader;
	}
	
	public int getCount(){
		return this.count;
	}

	public void printWordCount(Map<String, Integer> map){
		
		if(log.isInfoEnabled()){
			for(Map.Entry<String, Integer> wordCount : map.entrySet()){
				log.info("Word = " + wordCount.getKey() + " count = " + wordCount.getValue());
			}
		}
		
	}
	
	public void operateOnLine(List<String> wordList, String line){
		String[] words;
		words = line.trim().split(" ");
		for(String word : words)
		{
			String operatedWord = word.replaceAll("[^a-zA-Z]", "").trim(); 
        	if(!operatedWord.isEmpty())
        	{   
        		wordList.add(operatedWord);
        	}
		}		
	}

	public List<String> generateListOfWords(){
		
		String line;
		List<String> wordList = new ArrayList<>();
		try{
			while((line = reader.readLine()) != null){
				this.operateOnLine(wordList, line);
			}
			reader.close();
		}catch (IOException e) {
			log.warn("IO Exception occured", e);
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
