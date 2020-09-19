package com.philips.sender.operation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opencsv.CSVReader;


public class CsvReader {
	
	private static Logger log = Logger.getLogger(CsvReader.class.getName());
	
	private String filepath;
	
	public CsvReader(String filepath)
	{
		this.filepath = filepath;
	}
	
	public List<String[]> readUsingBufferedReader(){
		List<String[]> list = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
			
			String row;
			while ((row = reader.readLine()) != null) {
			    String[] data = row.split(",");
			    if(data.length > 1){
			    	list.add(data);
			    }
			}
		} catch (IOException e) {
			log.warn("IO Exception occured", e);
		}
		
		return list;
	}
	
	public  List<String[]> readCsv()
	{
		List<String[]> list = new ArrayList<>();
		try(CSVReader csvr = new CSVReader(new FileReader(filepath))) {
			
			String[] nextRecord;
			
			while((nextRecord = csvr.readNext()) != null)
			{
				list.add(nextRecord);
			}
			
		} catch (IOException e) {
			
			log.warn("IO Exception occured", e);
		}
		return list;
	}

}
