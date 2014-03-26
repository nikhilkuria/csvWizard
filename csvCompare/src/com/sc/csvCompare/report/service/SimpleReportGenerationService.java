package com.sc.csvCompare.report.service;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.report.helper.ReportHelper;
 
public class SimpleReportGenerationService implements ReportGenerationService {

	public void generateReport(CompareOutput output) throws IOException {
		ReportHelper reportHelper = new ReportHelper();
		HtmlCanvas canvas = new HtmlCanvas();
		
		reportHelper.initCanvas(canvas);
		//Create Header Compare header
		if(ConfigurationsStore.compareHeaders){
			reportHelper.createHeaderForHeader(canvas);
			reportHelper.createBodyForHeader(canvas);
		}
		
		reportHelper.closeCanvas(canvas);
	}

}
