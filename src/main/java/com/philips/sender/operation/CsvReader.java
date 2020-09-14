package com.philips.sender.operation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;


public class CsvReader {
	
	private String filepath;
	
	public CsvReader(String filepath)
	{
		this.filepath = filepath;
	}
	
	public  List<String[]> readCsv() throws  IOException
	{
		List<String[]> list = new ArrayList<String[]>();
		CSVReader csvr  = new CSVReader(new FileReader(filepath)); 
		String nextRecord[];
		while((nextRecord = csvr.readNext()) != null)
		{
					
					list.add(nextRecord);
					
					
		}
		
		return list;
	}

}
