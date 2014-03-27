package com.sc.csvCompare.report.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.report.service.ReportGenerationService;
import com.sc.csvCompare.report.service.SimpleReportGenerationService;

public class ReportGenerator {

	public void generateHtmlReport(CompareOutput output){
		ReportGenerationService reportService = new SimpleReportGenerationService();
		String report = null;
		try {
			report = reportService.generateReport(output);
			if(report!=null){
				printReport(report);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void printReport(String report) throws IOException {
		File reportFile = new File(ConfigurationsStore.reportLocation);
		FileWriter fw = new FileWriter(reportFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(report);
		bw.close();		
		
	}
	
}
