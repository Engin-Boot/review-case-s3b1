package com.philips.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitAndPrint {
	
	public List<String> prepareList(List<String[]> comments){
		
		List<String>  wordList = new ArrayList<String>();
		String[] arr;
		for(String[] str : comments)
		{
			if(!str[1].isEmpty()) 
			{
				arr = str[1].split(" ");
			
				for(String s : arr)
				{
					String result = s.replaceAll("[-+.^:,]","");
					Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");     //^[a-zA-Z0-9]+$ for including special symbols also
			        Matcher matcher = pattern.matcher(result);
			        boolean isStringContainsSpecialCharacter = matcher.find();
			        if(!(isStringContainsSpecialCharacter))
			        {
			        	if(!(s.isEmpty())  &&  !(s.isBlank()))
			        	{
			        		wordList.add(s);
			        	}
			        }		
				}		
			}
		}
		return wordList;
	}


  public void printToConsole(List<String> wordList)
  {
	  for(String str : wordList) {
		  System.out.println(str);
	  }
	  
  }
  
}
