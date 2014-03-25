package com.sc.test.csvCompare.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.config.ConfigurationsManager;
import com.sc.csvCompare.core.CsvComparer;

public class CsvCompareTest {

	@Test
	public void compareTest() throws FileNotFoundException, IOException{
		File expectedFile = new File("test-resources/expected-heading-1.txt");
		File actualFile = new File("test-resources/actual-heading-1.txt");
		File configFile = new File("test-resources/csv-config.properties");
		ConfigurationsManager.initializeManager(configFile);
		CsvComparer comparer = new CsvComparer();
		CompareOutput output = comparer.compareCsvFiles(expectedFile, actualFile);
	}
	
}
