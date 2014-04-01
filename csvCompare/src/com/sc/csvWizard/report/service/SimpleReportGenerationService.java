package com.sc.csvWizard.report.service;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;

import com.sc.csvWizard.bean.CompareOutput;
import com.sc.csvWizard.config.ConfigurationsStore;
import com.sc.csvWizard.report.helper.CommonReportHelper;
import com.sc.csvWizard.report.helper.ReportHeaderCompareHelper;
import com.sc.csvWizard.report.helper.ReportRowsCompareHelper;
 
public class SimpleReportGenerationService implements ReportGenerationService {

	public String generateReport(CompareOutput output) throws IOException {
		ReportHeaderCompareHelper reportHeaderHelper = new ReportHeaderCompareHelper();
		ReportRowsCompareHelper reportRowsHelper = new ReportRowsCompareHelper();
		CommonReportHelper commonReportHelper = new CommonReportHelper();
		HtmlCanvas canvas = new HtmlCanvas();
		
		commonReportHelper.initCanvas(canvas);
		
		commonReportHelper.createReportHeader(canvas,output);
		
		//Create Header Compare header
		if(ConfigurationsStore.compareHeaders){
		reportHeaderHelper.createHeaderComparision(canvas,output);
		}
		
		reportRowsHelper.createRowsComparision(canvas,output);
		
		
		commonReportHelper.closeCanvas(canvas);
		
		return canvas.toHtml();
	}

}
