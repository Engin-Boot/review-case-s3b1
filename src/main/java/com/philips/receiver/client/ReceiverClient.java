package com.philips.receiver.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.philips.receiver.operations.CsvWrite;
import com.philips.receiver.operations.WordCount;
import com.philips.receiver.service.ICount;
import com.philips.receiver.service.IWriter;

public class ReceiverClient {

	public static void main(String[] args) {
		
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		ICount wc = new WordCount(reader);
		IWriter writer = new CsvWrite();
		List<String> wordList = wc.generateListOfWords();
		Map<String, Integer> wordCountMap = wc.generateWordCount(wordList);
		wc.printWordCount(wordCountMap);
		writer.generateCsvFile(wordCountMap, System.getProperty("user.dir")+"\\src\\main\\resources\\word-count.csv");
	}

}
