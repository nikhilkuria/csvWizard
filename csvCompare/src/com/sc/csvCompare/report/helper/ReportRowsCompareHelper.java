package com.sc.csvCompare.report.helper;

import static org.rendersnake.HtmlAttributesFactory.bgcolor;
import static org.rendersnake.HtmlAttributesFactory.colspan;
import static org.rendersnake.HtmlAttributesFactory.style;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.MismatchRow;
import com.sc.csvCompare.bean.RowElement;
import com.sc.csvCompare.bean.RowsCompliment;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.report.style.InfoHeader;
import com.sc.csvCompare.report.style.RowsCompareHeaderStyle;
import com.sc.csvCompare.report.style.SectionInternalHederLevelOne;
import com.sc.csvCompare.report.style.StandardMessage;

public class ReportRowsCompareHelper {

	ReportCssHelper cssHelper;
	CommonReportHelper reportHelper;

	public ReportRowsCompareHelper() {
		cssHelper = new ReportCssHelper();
		reportHelper = new CommonReportHelper();
	}

	public void createRowsComparision(HtmlCanvas canvas, CompareOutput output)
			throws IOException {
		canvas.tr().td().table();

		reportHelper.createHeader(canvas, ReportVariables.ROWS_COMPARE_HEADER,
				new RowsCompareHeaderStyle());
		if (output.getRowsCompliment().isRowsMismatch()) {
			createBodyForRowsCompare(canvas, output);
		}
		createSummaryForRowsCompare(canvas, output);

		canvas._table()._td()._tr();

	}

	private void createSummaryForRowsCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		canvas.tr()
				.td()
				.table()
				.tr()
				.td(style(ReportCssHelper.getStyleString(new SectionInternalHederLevelOne())))
				.content("Summary")._tr().tr();
		if (output.getRowsCompliment().isRowsMismatch()) {
			canvas.td();
			reportHelper.createTableFromList(canvas, new ArrayList<String>(),
					"Missing Rows "
							+ "("
							+ output.getRowsCompliment().getMissingRows()
									.size() + ")", new InfoHeader(), false);
			canvas._td();
			canvas.td();
			reportHelper.createTableFromList(canvas, new ArrayList<String>(),
					"Extra Rows" + "("
							+ output.getRowsCompliment().getExtraRows().size()
							+ ")", new InfoHeader(), false);
			canvas._td();
			if (ConfigurationsStore.showCommonRows) {
				canvas.td();
				reportHelper.createTableFromList(canvas,
						new ArrayList<String>(), "Common Rows"
								+ "("
								+ output.getRowsCompliment().getCommonRows()
										.size() + ")", new InfoHeader(), false);
				canvas._td();
			}
		} else {
			canvas.td(style(ReportCssHelper.getStyleString(new StandardMessage())))
					.content(ReportVariables.ROWS_COMPARE_SUCCESS_MESSAGE);
		}
		canvas._tr()._table()._td()._tr();

	}

	private void createBodyForRowsCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		RowsCompliment rowsCompliment = output.getRowsCompliment();
		canvas.tr().td();
		
		if(!rowsCompliment.getMismatchRow().isEmpty()){
			createMismatchRowsSection(canvas,rowsCompliment);
		}
		
		reportHelper.createTableFromRowList(canvas,
				rowsCompliment.getMissingRows(), "Missing Rows",
				new SectionInternalHederLevelOne(), true);
		canvas.br();
		canvas._td()._tr();

		canvas.tr().td();
		reportHelper.createTableFromRowList(canvas,
				rowsCompliment.getExtraRows(), "Extra Rows",
				new SectionInternalHederLevelOne(), true);
		canvas.br();
		canvas._td()._tr();
		if (ConfigurationsStore.showCommonRows) {
			canvas.tr().td();
			reportHelper.createTableFromRowList(canvas,
					rowsCompliment.getCommonRows(), "Common Rows",
					new SectionInternalHederLevelOne(), true);
			canvas.br();
			canvas._td()._tr();
		}
	}

	private void createMismatchRowsSection(HtmlCanvas canvas,
			RowsCompliment rowsCompliment) throws IOException {	
		canvas
			.table()
				.tr()
					.td(style(ReportCssHelper.getStyleString(new SectionInternalHederLevelOne())).colspan("10000")).content("Mismatch in Values")
				._tr();
		prepareIndexForRowsMismatch(canvas);

		for (MismatchRow mismatchRow : rowsCompliment.getMismatchRow()) {
			
			RowElement actualRow = mismatchRow.getActualRow();
			RowElement expectedRow = mismatchRow.getExpectedRow();
			List<Integer> mismatchIndices = mismatchRow.getMismatchIndices();
			List<String> highLightList;
			highLightList = getHighLightList(expectedRow,
					mismatchIndices);
			canvas
				.table();
			reportHelper.createRowFromList(canvas, expectedRow.getRowEntries(), highLightList , ReportVariables.MISMATCH_ELEMENT_COLOR,expectedRow.getLineNumber());
			highLightList = getHighLightList(actualRow,
					mismatchIndices);
			reportHelper.createRowFromList(canvas, actualRow.getRowEntries(), highLightList , ReportVariables.MISMATCH_ELEMENT_COLOR,actualRow.getLineNumber());
			canvas
				._table();
			canvas
				.tr()
					.td()
						.br()
					._td()
				._tr();
		}
		canvas
			.br()
				._table();
			
		
	}

	private List<String> getHighLightList(RowElement expectedRow,
			List<Integer> mismatchIndices) {
		List<String> highLightList = new ArrayList<String>();
		for (Integer index : mismatchIndices) {
			List<String> rowEntries = expectedRow.getRowEntries();
			highLightList.add(rowEntries.get(index));
		}
		return highLightList;
	}
	
	private void prepareIndexForRowsMismatch(HtmlCanvas canvas)
			throws IOException {
		canvas.tr()
				.td(colspan("10000"))
				.table()
				.tr()
				.td(bgcolor(ReportVariables.MISMATCH_ELEMENT_COLOR)
						.width("20"))
				._td()
				.td()
				.content(ReportVariables.ROWS_MISMATCH_ELEMENT)
				._tr()
				._table()
				.br()._td()._tr();

	}

}
