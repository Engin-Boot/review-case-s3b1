package com.philips.client;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import com.philips.operations.CsvReader;
import com.philips.operations.SplitAndPrint;

public class SenderClient {

	public static void main(String arg[]) throws CsvValidationException, IOException
	{	
	
	      String filepath = "C:\\Users\\sss\\Documents\\review-case-s3b1\\sample-review\\review-report.csv";
	      CsvReader csvReadObject = new CsvReader(filepath);
	 
			List<String[]>  listStringArrayObject = csvReadObject.readCsv();
		
	      SplitAndPrint sp = new SplitAndPrint();
	      List<String> listStringObject = sp.prepareList(listStringArrayObject);
	      sp.printToConsole(listStringObject);
	      
	      
	      
	}
}
