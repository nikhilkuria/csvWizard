package com.sc.csvCompare.report.helper;

import java.io.IOException;
import java.util.List;

import org.rendersnake.HtmlCanvas;

public class CommonReportHelper {

	
	public void initCanvas(HtmlCanvas canvas) throws IOException {
		canvas
			.html()
				.body()
					.table();
		
	}
	

	public void createHeader(HtmlCanvas canvas, String header) throws IOException {
		canvas
			.tr()
				.td()
					.table()
						.tr()
							.td().content(header)
						._tr()
					._table()
				._td()
			._tr();
	}
	
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
	

	public void closeCanvas(HtmlCanvas canvas) throws IOException {
		canvas
			._table()
				._body()
					._html();
		
	}
	
}
