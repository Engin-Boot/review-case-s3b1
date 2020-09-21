package com.philips.testSender;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.philips.sender.operation.CsvReader;

public class SenderTest 
{
  

	@Test
	public void checkFileEmpty() {
		String filename = "\\senderTestSample1.csv";
		CsvReader csvr = new CsvReader(filename);
		 assertFalse(filename.isEmpty());
	}
	
	@Test
	public void checkRowCount() {
		String filepath = "\\senderTestSample1.csv";
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
	
	
	
}

