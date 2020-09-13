package com.philips.receiver.service;

import java.util.List;
import java.util.Map;

public interface ICount {

	Map<String, Integer> generateWordCount(List<String> wordList);
	void printWordCount(Map<String, Integer> map);
	List<String> generateListOfWords();
}
