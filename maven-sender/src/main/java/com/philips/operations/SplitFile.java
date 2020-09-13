package com.philips.operations;

import java.util.ArrayList;
import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import com.philips.Service.ISplitFile;

public class SplitFile implements ISplitFile {
	
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
					//String result = s.replaceAll("[-+.^:,]","");
					//Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");     //^[a-zA-Z0-9]+$ for including special symbols also
			        //Matcher matcher = pattern.matcher(result);
			        //boolean isStringContainsSpecialCharacter = matcher.find();
			        //if(!(isStringContainsSpecialCharacter))
			        //{
			        	if(!(s.isEmpty())  &&  !(s.isBlank()))
			        	{   
			        		s = s.replaceAll("[^a-zA-Z0-9]", "");  
			        		wordList.add(s);
			        	}
			        //}		
				}		
			}
		}
		return wordList;
	}


 
  
}

