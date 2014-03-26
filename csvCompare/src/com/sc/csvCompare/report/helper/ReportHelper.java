package com.sc.csvCompare.report.helper;

import java.io.IOException;

import org.rendersnake.HtmlCanvas;
import org.rendersnake.internal.CharactersWriteable;

public class ReportHelper {

	ReportCssHelper cssHelper;
	
	public ReportHelper(){
		cssHelper = new ReportCssHelper();
	}
	
	public void initCanvas(HtmlCanvas canvas) throws IOException {
		canvas
			.html()
				.body()
					.table();
		
	}
	
	public void createHeaderForHeader(HtmlCanvas canvas) throws IOException {
		canvas
			.tr();
	}

	public void createBodyForHeader(HtmlCanvas canvas) {
		// TODO Auto-generated method stub
		
	}

	public void closeCanvas(HtmlCanvas canvas) throws IOException {
		canvas
			._table()
				._body()
					._html();
		
	}

	
}
