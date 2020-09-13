package com.philips.Service;

import java.util.List;

public interface ISplitAndPrint {
	
	List<String> prepareList(List<String[]> comments);
	 void printToConsole(List<String> wordList);


}
