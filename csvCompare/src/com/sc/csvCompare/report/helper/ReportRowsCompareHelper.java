package com.sc.csvCompare.report.helper;

import static org.rendersnake.HtmlAttributesFactory.style;

import java.io.IOException;
import java.util.ArrayList;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.RowsCompliment;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.report.style.InfoHeader;
import com.sc.csvCompare.report.style.RowsCompareHeaderStyle;
import com.sc.csvCompare.report.style.SectionInternalHederLevelOne;
import com.sc.csvCompare.report.style.StandardMessage;

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
		
		reportHelper.createHeader(canvas, ReportVariables.ROWS_COMPARE_HEADER,new RowsCompareHeaderStyle());
		if(output.getRowsCompliment().isRowsMismatch()){
			createBodyForRowsCompare(canvas,output);			
		}
		createSummaryForRowsCompare(canvas,output);
		
		canvas
					._table()
				._td()
			._tr();
		
	}

	private void createSummaryForRowsCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		canvas
		.tr()
			.td()
				.table()
					.tr()
						.td(style(reportHelper.getStyleString(new SectionInternalHederLevelOne()))).content("Summary")
					._tr()
					.tr();
						if (output.getRowsCompliment().isRowsMismatch()) {
							canvas.td();
							reportHelper
									.createTableFromList(canvas, new ArrayList<String>(),
											"Missing Rows " + "(" +output.getRowsCompliment().getMissingRows().size() + ")",new InfoHeader());
							canvas._td();
							canvas.td();
							reportHelper.createTableFromList(canvas, new ArrayList<String>(),
											"Extra Rows"  + "(" +output.getRowsCompliment().getExtraRows().size() + ")", new InfoHeader());
							canvas._td();
							if (ConfigurationsStore.showCommonRows) {
								canvas.td();
								reportHelper.createTableFromList(canvas,
										new ArrayList<String>(), "Common Rows"
												+ "("
												+ output.getRowsCompliment()
														.getCommonRows().size()
												+ ")", new InfoHeader());
								canvas._td();
							}
						}else{
							canvas.td(style(reportHelper.getStyleString(new StandardMessage()))).content(ReportVariables.ROWS_COMPARE_SUCCESS_MESSAGE);
						}
					canvas
					._tr()
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
		reportHelper.createTableFromList(canvas, rowsCompliment.getListofMissingRows(), "Missing Rows", new SectionInternalHederLevelOne());
		canvas
				._td()
			._tr();
		
		canvas
		.tr()
			.td();
		reportHelper.createTableFromList(canvas, rowsCompliment.getListofExtraRows(), "Extra Rows", new SectionInternalHederLevelOne());
		canvas
			._td()
		._tr();
		if (ConfigurationsStore.showCommonRows) {
		canvas	
			.tr()
			.td();
		reportHelper.createTableFromList(canvas, rowsCompliment.getListofCommonRows(), "Common Rows", new SectionInternalHederLevelOne());
		canvas
			._td()
		._tr();
		}
	}

}
