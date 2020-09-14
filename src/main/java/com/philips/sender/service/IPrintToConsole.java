package com.philips.sender.service;

import java.util.List;

public interface IPrintToConsole {

	 void printToConsole(List<String[]> wordList,int index);
	 int getIndexForColumnName(String[] fileHeader, String columnName);
}
