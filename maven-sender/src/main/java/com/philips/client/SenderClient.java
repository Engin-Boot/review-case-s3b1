package com.philips.client;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import com.philips.Service.IPrintToConsole;
import com.philips.Service.ISplitFile;
import com.philips.operations.CsvReader;
import com.philips.operations.PrintToConsole;
import com.philips.operations.SplitFile;

public class SenderClient {

	public static void main(String arg[]) throws CsvValidationException, IOException
	{	
	
	      String filepath = "C:\\Users\\sss\\Documents\\review-case-s3b1\\sample-review\\review-report.csv";
	      CsvReader csvReadObject = new CsvReader(filepath);
	 
			List<String[]>  listStringArrayObject = csvReadObject.readCsv();
		
	      ISplitFile sp = new SplitFile();
	      List<String> listStringObject = sp.prepareList(listStringArrayObject);
	      
	      IPrintToConsole ptc = new PrintToConsole();
	      ptc.printToConsole(listStringObject);
	      
	      
	      
	      
	      
	}
}
