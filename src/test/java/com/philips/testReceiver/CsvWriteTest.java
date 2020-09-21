package com.philips.testReceiver;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.philips.receiver.operations.CsvWrite;

public class CsvWriteTest {
	
	@Test
	public void givenAMapStoringStringAndIntegerAndAFilePathGeneratesACsvFileIs(){
		Map<String, Integer> wordCount = new HashMap<>();
		wordCount.put("Sun", 3);
		wordCount.put("Jupiter", 4);
		
		String filepath = "src\\main\\resources\\word-count.csv";
		
		CsvWrite write = new CsvWrite();
		write.generateCsvFile(wordCount, filepath);
		
		File file = new File("src/main/resources/word-count.csv");
		assertTrue(file.exists());
	}
}
