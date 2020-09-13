package com.philips.receiver.service;

import java.util.Map;

public interface ICount {

	Map<String, Integer> generateWordCount();
	void printWordCount(Map<String, Integer> map);
}
