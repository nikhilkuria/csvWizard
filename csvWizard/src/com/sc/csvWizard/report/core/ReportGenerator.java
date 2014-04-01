package com.sc.csvWizard.report.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.sc.csvWizard.bean.CompareOutput;
import com.sc.csvWizard.config.ConfigurationsStore;
import com.sc.csvWizard.report.service.ReportGenerationService;
import com.sc.csvWizard.report.service.SimpleReportGenerationService;

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
		File reportFile = new File(getReportLocation());
		FileWriter fw = new FileWriter(reportFile);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(report);
		bw.close();		
		
	}

	public static String getReportLocation() {
		return ConfigurationsStore.reportLocation;
	}

	public void setReportLocation(String reportLocation) {
		ConfigurationsStore.reportLocation = reportLocation;
	}
	
}
