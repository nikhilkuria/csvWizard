package com.sc.csvWizard.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sc.csvWizard.bean.CompareOutput;
import com.sc.csvWizard.bean.CsvBean;
import com.sc.csvWizard.exception.ConfigNotFoundException;
import com.sc.csvWizard.service.BeanCreatorService;
import com.sc.csvWizard.service.CsvCompareService;
import com.sc.csvWizard.service.SimpleBeanCreatorService;
import com.sc.csvWizard.service.SimpleCsvCompareService;

public class CsvComparer {

	public CsvBean convertCsvToBean(File csvFile){
		CsvBean csvBean = null;
		BeanCreatorService beanCreatorService = new SimpleBeanCreatorService();
		try {
			csvBean = beanCreatorService.getBeanFromCsv(csvFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConfigNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return csvBean;
	}
	
	public CompareOutput compareCsvBeans(CsvBean expected, CsvBean actual){
		CsvCompareService csvCompareService = new SimpleCsvCompareService();
		CompareOutput compareOutput = null;
		try {
			compareOutput = csvCompareService.compareCsvBeans(expected, actual);
		} catch (ConfigNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compareOutput;
	}
	
	public CompareOutput compareCsvFiles(File expectedFile, File actualFile){
		CsvBean expectedBean = convertCsvToBean(expectedFile);
		CsvBean actualBean = convertCsvToBean(actualFile);
		
		return compareCsvBeans(expectedBean, actualBean);
	}
	
}
