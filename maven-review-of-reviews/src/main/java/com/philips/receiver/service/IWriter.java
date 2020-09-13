package com.philips.receiver.service;

import java.util.Map;

public interface IWriter {

	void generateCsvFile(Map<String, Integer> map, String filepath);
}
