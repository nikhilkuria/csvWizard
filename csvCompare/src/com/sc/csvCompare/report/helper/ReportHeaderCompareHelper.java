package com.sc.csvCompare.report.helper;

import static org.rendersnake.HtmlAttributesFactory.bgcolor;
import static org.rendersnake.HtmlAttributesFactory.colspan;

import java.io.IOException;
import java.util.List;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.HeadersCompliment;

public class ReportHeaderCompareHelper {

	ReportCssHelper cssHelper;
	CommonReportHelper reportHelper;
	
	public ReportHeaderCompareHelper(){
		cssHelper = new ReportCssHelper();
		reportHelper = new CommonReportHelper();
	}
	
	public void createHeaderComparision(HtmlCanvas canvas, CompareOutput output) throws IOException {
		canvas
			.tr()
				.td()
					.table();
		
		reportHelper.createHeader(canvas, ReportVariables.HEADER_COMPARE_HEADER);
		createIndexForHeaderCompare(canvas);
		createBodyForHeaderCompare(canvas,output);
		createSummaryForHeaderCompare(canvas,output);
		
		canvas
					._table()
				._td()
			._tr();
	}
	
	private void createSummaryForHeaderCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		canvas
			.tr()
				.td()
					.table()
						.tr()
							.td().content("Summary")
						._tr()
						.tr();
		canvas
							.td();
		
		reportHelper.createTableFromList(canvas, output.getHeadersCompliment().getMissingHeaders(),"Missing Headers");
		
		canvas
							._td();
		
		canvas
							.td();
		reportHelper.createTableFromList(canvas, output.getHeadersCompliment().getExtraHeaders(), "Extra Headers");
		
		canvas 
							._td();
		canvas
						._tr()
					._table()
				._td()
			._tr();
		
	}

	private void createBodyForHeaderCompare(HtmlCanvas canvas, CompareOutput output) throws IOException {
		HeadersCompliment headersCompliment = output.getHeadersCompliment();
		canvas
			.tr()
				.td()
					.table()
						.tr()
							.td(colspan("10000")).content("Expected Header from : " + output.getExpectedFileName())
						._tr();
		
		prepareHeaderList(canvas,headersCompliment.getExpectedHeaders(),headersCompliment.getMissingHeaders(),ReportVariables.HEADER_MISSING_ELEMENT_COLOR);
		
		canvas
						.tr()
							.td(colspan("10000")).content("Actual Header from : " + output.getActualFileName())
						._tr();
		
		prepareHeaderList(canvas,headersCompliment.getActualHeaders(),headersCompliment.getExtraHeaders(),ReportVariables.HEADER_EXTRA_ELEMENT_COLOR);
		canvas				
					._table()
				._td()
			._tr();
		
	}

	private void prepareHeaderList(HtmlCanvas canvas,
			List<String> masterList, List<String> highLightList,
			String markColor) throws IOException {
		canvas
			.tr();
		
		for (String header : masterList) {
			String color = ReportVariables.HEADER_NORMAL_COLOR;
			if(highLightList.contains(header)){
				color = markColor;
			}
			canvas
				.td(bgcolor(color)).content(header);
		}
		
		canvas
			._tr();
		
	}


	private void createIndexForHeaderCompare(HtmlCanvas canvas) throws IOException {
		canvas
			.tr()
				.td()
					.table()
						.tr()
							.td(bgcolor(ReportVariables.HEADER_MISSING_ELEMENT_COLOR))
							._td()
							.td().content(ReportVariables.HEADER_MISSING_ELEMENTS)
						._tr()
						.tr()
							.td(bgcolor(ReportVariables.HEADER_EXTRA_ELEMENT_COLOR))
							._td()
							.td().content(ReportVariables.HEADER_EXTRA_ELEMENTS)
						._tr()
					._table()	
				._td()
			._tr();
		
	}


}
