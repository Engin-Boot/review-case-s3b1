package com.philips.testReceiver;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import com.philips.receiver.operations.WordCount;

public class WordCountTest {
	
	private WordCount wc;

	@Test
	public void reportTrueIfFileExists(){
		File file = new File("./src/main/resources/word-count.csv");
		boolean value = file.exists();
		
		if(file.exists() && !file.isDirectory()){
			assertTrue(value);
		}
		else{
			assertFalse(value);
		}
	}
	
	@Test
	public void whenAStringContainsMultipleWordsThenEachWordMustGetAddedToTheList(){
		String multipleWords = "Illuminati is real";
		List<String> words = new ArrayList<>();
		
		wc = new WordCount();
		wc.operateOnLine(words, multipleWords);
		
		assertEquals(3, words.size());
		assertEquals("Illuminati", words.get(0));
		assertEquals("is", words.get(1));
		assertEquals("real", words.get(2));
	}
	
	@Test
	public void constructorTest(){
		wc = new WordCount(new BufferedReader(new InputStreamReader(System.in)));
		assertNotNull(wc.getReader());
		assertEquals(0,wc.getCount());
	}
	
	@Test
	public void readInputFromConsoleAndReturnAListContainingAllWordsInTheInput(){
		String consoleInput = "Newly added comment\nSun rises in the east\n";
		InputStream stream = new ByteArrayInputStream((consoleInput).getBytes(StandardCharsets.UTF_8));
		InputStream stdin = System.in; 
        System.setIn(stream);
        wc = new WordCount(new BufferedReader(new InputStreamReader(System.in)));
        List<String> wordList = wc.generateListOfWords();
        assertNotNull(wordList);
        assertEquals(8, wordList.size());
        assertEquals("Newly", wordList.get(0));
        assertEquals("added", wordList.get(1));
        assertEquals("comment", wordList.get(2));
        assertEquals("Sun", wordList.get(3));
        assertEquals("rises", wordList.get(4));
        assertEquals("in", wordList.get(5));
        assertEquals("the", wordList.get(6));
        assertEquals("east", wordList.get(7));
        System.setIn(stdin);
	}
	
	@Test
	public void givenAListOfStringWeGetAMapContainingCountOfEachWord(){
		wc = new WordCount();
		List<String> wordList = new ArrayList<>(Arrays.asList("Sun", "Moon", "Sun", "Sun", "Moon"));
		Map<String, Integer> map = wc.generateWordCount(wordList);
		assertTrue(map.containsKey("Sun"));
		assertTrue(map.containsKey("Moon"));
		assertFalse(map.containsKey("Jupiter"));
		
		if(map.containsKey("Sun")){
			assertEquals(3,  map.get("Sun").intValue());
		}
		else{
			assertNull(map.get("Sun"));
		}
		
		assertEquals(2, map.get("Moon").intValue());
		assertNull(map.get("Jupiter"));
	}

}
