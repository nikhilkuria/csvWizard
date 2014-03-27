package com.sc.csvCompare.report.helper;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.RowsCompliment;

public class ReportRowsCompareHelper {

	ReportCssHelper cssHelper;
	CommonReportHelper reportHelper;
	
	public ReportRowsCompareHelper(){
		cssHelper = new ReportCssHelper();
		reportHelper = new CommonReportHelper();
	}
	
	public void createRowsComparision(HtmlCanvas canvas, CompareOutput output) throws IOException {
		canvas
			.tr()
				.td()
					.table();
		
		reportHelper.createHeader(canvas, ReportVariables.ROWS_COMPARE_HEADER);
		createBodyForRowsCompare(canvas,output);
		
		canvas
					._table()
				._td()
			._tr();
		
	}

	private void createBodyForRowsCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		RowsCompliment rowsCompliment = output.getRowsCompliment();
		canvas
			.tr()
				.td();		
		reportHelper.createTableFromList(canvas, rowsCompliment.getListofMissingRows(), "Missing Rows");
		canvas
				._td()
			._tr();
		
		canvas
		.tr()
			.td();
		reportHelper.createTableFromList(canvas, rowsCompliment.getListofExtraRows(), "Extra Rows");
		canvas
			._td()
		._tr();
	}

}
