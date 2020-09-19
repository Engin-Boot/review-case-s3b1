package com.philips.receiver.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opencsv.CSVWriter;
import com.philips.receiver.service.IWriter;

public class CsvWrite implements IWriter{
	
	private static Logger log = Logger.getLogger(CsvWrite.class.getName());
	
	public void generateCsvFile(Map<String,Integer> wordCount, String filepath){
		
		File file = new File(filepath);
		try(FileWriter outputFile = new FileWriter(file)){
			
			try(CSVWriter writer = new CSVWriter(outputFile)){
				String[] header = { "word", "count"}; 
		        writer.writeNext(header); 
		  
		        // add data to CSV
		        for(Map.Entry<String, Integer> entry: wordCount.entrySet()){
		        	String[] countPair = {entry.getKey(), entry.getValue().toString()};
		        	writer.writeNext(countPair);
		        }
			}
			
		}catch (IOException e){
			log.warn("IO Exception occured ", e);
		}
	}
}
