package com.philips.sender.operation;

import java.util.List;

import org.apache.log4j.Logger;
import com.philips.sender.service.IPrintToConsole;

public class PrintToConsole implements IPrintToConsole {
	
	private static Logger log = Logger.getLogger(PrintToConsole.class.getName());
	
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
    			log.info(str[index]);
    		}
    	}
	 }

}
