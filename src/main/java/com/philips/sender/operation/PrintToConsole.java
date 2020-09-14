package com.philips.sender.operation;

import java.util.List;

import com.philips.sender.service.IPrintToConsole;

public class PrintToConsole implements IPrintToConsole {

	
	 public void printToConsole(List<String[]> wordList, String value)
	  {
		  for(String[] str : wordList) 
		  {
			  if(value.equals("comment"))
			  {
				 if(!(str[1].isEmpty()))
				 {
					 System.out.println(str[1]);
				 }
			  }
			  if(value.equals("Date"))
			  {	
				  if(!(str[0].isEmpty()))
				  {
					  System.out.println(str[0]);
				  }
			  }
	  	  }
	  }
}
