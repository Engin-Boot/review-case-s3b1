package com.philips.sender.client;

import java.io.IOException;
import java.util.List;

import com.philips.sender.service.IPrintToConsole;
import com.philips.sender.operation.CsvReader;
import com.philips.sender.operation.PrintToConsole;

public class SenderClient {

	public static void main(String arg[]) throws  IOException
	{	
		
			//String filepath = "C:\\Users\\sss\\Documents\\review-case-s3b1\\sample-review\\review-report.csv";
	      
			//System.out.println("Welcome");
			String filepath = arg[0];
			String value = arg[1];
			CsvReader csvReadObject = new CsvReader(filepath);
	 
			List<String[]>  listStringArrayObject = csvReadObject.readCsv();
			
			IPrintToConsole ptc = new PrintToConsole();
			ptc.printToConsole(listStringArrayObject,value);
	      
	      
	      
	      
	      
	}
}
