package com.sc.csvCompare.report.helper;

import static org.rendersnake.HtmlAttributesFactory.bgcolor;
import static org.rendersnake.HtmlAttributesFactory.colspan;
import static org.rendersnake.HtmlAttributesFactory.style;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.HeadersCompliment;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.report.style.GeneralInfoMessage;
import com.sc.csvCompare.report.style.SectionHeaderStyle;
import com.sc.csvCompare.report.style.SecondLevelHeader;
import com.sc.csvCompare.report.style.SectionInternalHederLevelOne;
import com.sc.csvCompare.report.style.StandardMessage;

public class ReportHeaderCompareHelper {

	ReportCssHelper cssHelper;
	CommonReportHelper reportHelper;

	public ReportHeaderCompareHelper() {
		cssHelper = new ReportCssHelper();
		reportHelper = new CommonReportHelper();
	}

	public void createHeaderComparision(HtmlCanvas canvas, CompareOutput output)
			throws IOException {
		HeadersCompliment headersCompliment = output.getHeadersCompliment();
		canvas.tr().td().table();

		reportHelper.createHeader(canvas,
				ReportVariables.HEADER_COMPARE_HEADER,
				new SectionHeaderStyle());
		if (headersCompliment.isHeadersMismatch()) {
			if (ConfigurationsStore.colorMapping) {
				createIndexForHeaderCompare(canvas);
			}
		}
		if (ConfigurationsStore.colorMapping) {
			createBodyForHeaderCompare(canvas, output);
		}
		createSummaryForHeaderCompare(canvas, output);

		canvas._table().hr()._td()._tr();
	}

	private void createSummaryForHeaderCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		canvas.tr()
				.td()
				.table()
				.tr()
				.td(style(ReportCssHelper.getStyleString(new SectionInternalHederLevelOne())))
				.content("Summary")._tr().tr();
		if (output.getHeadersCompliment().isHeadersMismatch()) {
			canvas.td(style("vertical-align:top"));
			reportHelper.createTableFromList(canvas, output
					.getHeadersCompliment().getMissingHeaders(),
					"Missing Headers "
							+ "("
							+ output.getHeadersCompliment().getMissingHeaders()
									.size() + ")", new SecondLevelHeader(),false);
			canvas._td();
			canvas.td(style("vertical-align:top"));
			reportHelper.createTableFromList(canvas, output
					.getHeadersCompliment().getExtraHeaders(), "Extra Headers"
					+ "("
					+ output.getHeadersCompliment().getExtraHeaders().size()
					+ ")", new SecondLevelHeader(),false);
			canvas._td();
			if (ConfigurationsStore.showCommonHeaders) {
				canvas.td(style("vertical-align:top"));
				reportHelper.createTableFromList(canvas, output
						.getHeadersCompliment().getCommonHeaders(),
						"Common Headers"
								+ "("
								+ output.getHeadersCompliment()
										.getCommonHeaders().size() + ")",
						new SecondLevelHeader(),false);
				canvas._td();
			}
		} else {
			canvas.td(style(ReportCssHelper.getStyleString(new StandardMessage())))
					.content(ReportVariables.HEADER_COMPARE_SUCCESS_MESSAGE);
		}
		canvas._tr()._table()._td()._tr();

	}

	private void createBodyForHeaderCompare(HtmlCanvas canvas,
			CompareOutput output) throws IOException {
		HeadersCompliment headersCompliment = output.getHeadersCompliment();
		canvas.tr()
				.td()
				.table()
				.tr()
				.td(colspan("10000").style(
						ReportCssHelper.getStyleString(new GeneralInfoMessage())))
				.content(
						"Expected Header from : "
								+ output.getExpectedFileName())._tr();

		reportHelper.createRowFromList(canvas, headersCompliment.getExpectedHeaders(),
				headersCompliment.getMissingHeaders(),
				ReportVariables.HEADER_MISSING_ELEMENT_COLOR);

		canvas.tr()
				.td(colspan("10000").style(
						ReportCssHelper.getStyleString(new GeneralInfoMessage())))
				.content("Actual Header from : " + output.getActualFileName())
				._tr();

		reportHelper.createRowFromList(canvas, headersCompliment.getActualHeaders(),
				headersCompliment.getExtraHeaders(),
				ReportVariables.HEADER_EXTRA_ELEMENT_COLOR);
		canvas._table().br()._td()._tr();

	}

	private void createIndexForHeaderCompare(HtmlCanvas canvas)
			throws IOException {
		canvas.tr()
				.td()
				.table()
				.tr()
				.td(bgcolor(ReportVariables.HEADER_MISSING_ELEMENT_COLOR)
						.width("20"))
				._td()
				.td()
				.content(ReportVariables.HEADER_MISSING_ELEMENTS)
				._tr()
				.tr()
				.td(bgcolor(ReportVariables.HEADER_EXTRA_ELEMENT_COLOR).width(
						"20"))._td().td()
				.content(ReportVariables.HEADER_EXTRA_ELEMENTS)._tr()._table()
				.br()._td()._tr();

	}

}
