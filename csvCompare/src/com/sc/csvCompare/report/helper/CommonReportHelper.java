package com.sc.csvCompare.report.helper;

import static org.rendersnake.HtmlAttributesFactory.bgcolor;
import static org.rendersnake.HtmlAttributesFactory.style;

import java.io.IOException;
import java.util.List;

import org.rendersnake.HtmlCanvas;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.report.style.SectionStyle;
import com.sc.csvCompare.util.CsvCompareConstants;

public class CommonReportHelper {

	
	public void initCanvas(HtmlCanvas canvas) throws IOException {
		canvas
			.html()
				.body()
					.table(style("width:100%"));
		
	}
	

	public void createHeader(HtmlCanvas canvas, String header, SectionStyle headerStyle) throws IOException {
		String style = getStyleString(headerStyle);
		canvas
			.tr()
				.td()
					.table()
						.tr()
							.td(style(style)).content(header)
						._tr()
					._table()
				._td()
			._tr();
	}


	public String getStyleString(SectionStyle headerStyle) {
		String style = "color:"+headerStyle.getFontColor()+";text-align:"+headerStyle.getAlignment()+
				";font-weight:"+headerStyle.getFontWeight()+";font-size:"+headerStyle.getFontSize()+
				";vertical-align:"+headerStyle.getVerticalAlign();
		return style;
	}
	
	public void createTableFromList(HtmlCanvas canvas,List<String> entries, String header, SectionStyle sectionStyle,boolean showEmptyMessage) throws IOException{
		canvas
			.table();
		canvas
				.tr()
					.td(style(getStyleString(sectionStyle))).content(header)
				._tr();
		for (String entry : entries) {
			canvas
				.tr()
					.td().content(entry)
				._tr();
		}
		if(entries.isEmpty() && showEmptyMessage) {
			canvas
				.tr()
					.td().content("none..")
				._tr();
		}
		canvas
			._table();
	}
	

	public void closeCanvas(HtmlCanvas canvas) throws IOException {
		canvas
			._table()
				._body()
					._html();
		
	}


	public void createReportHeader(HtmlCanvas canvas, CompareOutput output) throws IOException {		
		canvas
			.tr()
				.td()
					.table(style("width:100%"))
						.tr()
							.td(style(ReportCssHelper.reportHeaderStyle)).content(ReportVariables.REPORT_MAIN_HEADER)
							.td().content(CsvCompareConstants.VERSION)
						._tr()
						.tr()
							.td(style(ReportCssHelper.fileNameStyle)).content("Expected File Name : "+output.getExpectedFileName())
						._tr()
						.tr()
							.td(style(ReportCssHelper.fileNameStyle)).content("Actual File Name : "+output.getActualFileName())
						._tr()
					._table()
					.hr()
				._td()
			._tr();
		
	}
	
	public void createRowFromList(HtmlCanvas canvas, List<String> masterList,
			List<String> highLightList, String markColor) throws IOException {
		canvas.tr();

		for (String header : masterList) {
			String color = ReportVariables.HEADER_NORMAL_COLOR;
			if (highLightList.contains(header)) {
				color = markColor;
			}
			canvas.td(bgcolor(color)).content(header);
		}

		canvas._tr();

	}
	
}
