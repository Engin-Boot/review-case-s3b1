package com.philips.testSender;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
		List<String[]> lineCount = csvr.readUsingBufferedReader();
		assertEquals(lineCount.size(),5);
		//assertTrue(lineCount.size() == 3);
	}
	

	@Test
	public void testDateIsNull() {
		DateFormat df = new DateFormat();
		assertFalse(df.isThisDateValid(null, "dd//mm/yyyy"));
	}
	
	@Test
	public void testDayIsInvalid() {
		DateFormat df = new DateFormat();
		assertFalse(df.isThisDateValid("32/02/2012", "dd/MM/yyyy"));
	}

	@Test
	public void testMonthIsInvalid() {
		DateFormat df = new DateFormat();
		assertFalse(df.isThisDateValid("31/20/2012", "dd/MM/yyyy"));
	}

	@Test
	public void testYearIsInvalid() {
		DateFormat df = new DateFormat();
		assertFalse(df.isThisDateValid("31/20/19991", "dd/MM/yyyy"));
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
	      List<String[]> wordList = csvr.readUsingBufferedReader();
	      PrintToConsole printing = new PrintToConsole();
	      printing.printToConsole(wordList, 1);
	      
	      String expectedOutput  = "comments\nThis is a boy"; 

	     
	     assertEquals(expectedOutput, outContent.toString());
	}
	
	
}


