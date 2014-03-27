package com.sc.csvCompare.report.service;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.report.helper.ReportHeaderCompareHelper;
 
public class SimpleReportGenerationService implements ReportGenerationService {

	public String generateReport(CompareOutput output) throws IOException {
		ReportHeaderCompareHelper reportHelper = new ReportHeaderCompareHelper();
		HtmlCanvas canvas = new HtmlCanvas();
		
		reportHelper.initCanvas(canvas);
		//Create Header Compare header
		if(ConfigurationsStore.compareHeaders){
		reportHelper.createHeaderComparision(canvas,output);
		}
		
		reportHelper.closeCanvas(canvas);
		
		return canvas.toHtml();
	}

}
