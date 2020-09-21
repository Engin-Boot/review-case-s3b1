package com.philips.testSender;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;

import com.philips.sender.operation.CsvReader;
import com.philips.sender.operation.PrintToConsole;

public class SenderTest 
{
  

	@Test
	public void checkFileEmpty() { 
		String filename = "\\src\\test\\resources\\senderTestSample1.csv";
		CsvReader csvr = new CsvReader(filename);
		 assertFalse(filename.isEmpty());
	}
	

	
	@Test
	public void checkRowCount() {
		String filepath = "\\src\\test\\resources\\senderTestSample2.csv";
		CsvReader csvr = new CsvReader(filepath);
		List<String[]> lineCount = csvr.whenFileFoundThenReadUsingBufferedReader();
		assertEquals(lineCount.size(),7);
		
	}
	

	@Test
	public void testDateIsNull() {
		DateFormat df = new DateFormat();
		assertFalse(df.isThisDateValid(null, "dd//mm/yyyy"));
	}
	
	
	@Test
	public void testDateFormatIsInvalid() {
		DateFormat df = new DateFormat();
		assertFalse(df.isThisDateValid("2012/02/20", "dd/MM/yyyy"));
	}
	
	@Test
	public void printTest() throws Exception {
	      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      String filename = "\\src\\test\\resources\\senderTestSample1.csv";
	      CsvReader csvr = new CsvReader(filename);
	      List<String[]> wordList = csvr.whenFileFoundThenReadUsingBufferedReader();
	      PrintToConsole printing = new PrintToConsole();
	      printing.printToConsole(wordList, 1);
	      
	      String expectedOutput  = "comments\nwhat does this help with?\nchange spelling"; 

	     
	     assertEquals(expectedOutput, outContent.toString());
	}
	
	
}


