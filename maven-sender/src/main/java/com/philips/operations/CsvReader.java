package com.philips.operations;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {
	
	private String filepath;
	
	public CsvReader(String filepath)
	{
		this.filepath = filepath;
	}
	
	public  List<String[]> readCsv() throws CsvValidationException, IOException
	{
		List<String[]> list = new ArrayList<String[]>();
		CSVReader csvr  = new CSVReader(new FileReader(filepath)); 
		String nextRecord[];
		while((nextRecord = csvr.readNext()) != null)
		{
				if(nextRecord[1] != " ") 
				{
					list.add(nextRecord);
				}
		}
		
		return list;
	}

}
