package com.philips.testSender;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.philips.sender.operation.CsvReader;
import com.philips.sender.operation.PrintToConsole;

public class SenderTest 
{
  

	@Test
	public void checkFileEmpty() { 
		String filename = "src/test/resources/senderTestSample1.csv";
		 assertFalse(filename.isEmpty());
	}
	

	
	@Test
	public void checkRowCount() {
		String filepath = "src/test/resources/senderTestSample2.csv";
		CsvReader csvr = new CsvReader(filepath);
		List<String[]> lineCount = csvr.readUsingBufferedReader();
		assertEquals(6,lineCount.size());
		
	}
	

	@Test
	public void checkHeaderCount() {
		String filepath = "src\\test\\resources\\senderTestSample1.csv";
		CsvReader csvr = new CsvReader(filepath);
		List<String[]> lineCount = csvr.readUsingBufferedReader();
		String columnName[] = lineCount.get(0);
		PrintToConsole print = new PrintToConsole();
		int index = print.getIndexForColumnName(columnName,"Comments");
		assertEquals("ReviewDate",columnName[0]);
		
		assertEquals("Comments",columnName[1]);
		
		assertEquals(1,index);
		
	}
	
	
	
	/*@Test
	public void printTest() throws Exception {
	      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(outContent));
	      
	      String filename = "src\\test\\resources\\senderTestSample1.csv";
	      CsvReader csvr = new CsvReader(filename);
	      List<String[]> wordList = csvr.readUsingBufferedReader();
	      PrintToConsole printing = new PrintToConsole();
	      printing.printToConsole(wordList, 1);
	      
	      String expectedOutput  = "Comments\nwhat does this help with?\nchange spelling"; 

	      String line = outContent.
	     assertEquals(expectedOutput, outContent.toString());
	}*/
	
	
}


