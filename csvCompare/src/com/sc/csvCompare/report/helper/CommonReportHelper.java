package com.sc.csvCompare.report.helper;

import java.io.IOException;
import java.util.List;

import org.rendersnake.HtmlCanvas;

public class CommonReportHelper {

	public void createTableFromList(HtmlCanvas canvas,List<String> entries, String header) throws IOException{
		canvas
			.table();
		canvas
				.tr()
					.td().content(header)
				._tr();
		for (String entry : entries) {
			canvas
				.tr()
					.td().content(entry)
				._tr();
		}
		canvas
			._table();
	}
	
}
