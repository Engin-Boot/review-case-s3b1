package com.philips.sender.operation;

import java.util.List;

import com.philips.sender.service.IPrintToConsole;

public class PrintToConsole implements IPrintToConsole {
	
	@Override
	public int getIndexForColumnName(String[] fileHeader, String columnName) {
		
		int index = 0;
		for(int i = 0; i < fileHeader.length; i++){
			if(fileHeader[i].equalsIgnoreCase(columnName)){
				index = i;
				break;
			}
		}
		return index;
	}
	
    public void printToConsole(List<String[]> wordList, int index)
	{	
    	for(String[] str : wordList) 
    	{
    		if(!(str[index].isEmpty()))
    		{
    			System.out.println(str[index]);
    		}
    	}
	 }

}
