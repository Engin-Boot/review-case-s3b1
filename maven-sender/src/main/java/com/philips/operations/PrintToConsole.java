package com.philips.operations;

import java.util.List;

import com.philips.Service.IPrintToConsole;

public class PrintToConsole implements IPrintToConsole {

	
	 public void printToConsole(List<String> wordList)
	  {
		  for(String str : wordList) {
			  System.out.println(str);
		  }
		  
	  }
}
