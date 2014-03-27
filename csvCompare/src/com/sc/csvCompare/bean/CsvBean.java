package com.sc.csvCompare.bean;

import java.util.List;

public class CsvBean {

	private List<RowElement> rows;
	private HeaderElement header;
	private String fileName;
	
	public List<RowElement> getRows() {
		return rows;
	}
	public void setRows(List<RowElement> rows) {
		this.rows = rows;
	}
	public HeaderElement getHeader() {
		return header;
	}
	public void setHeader(HeaderElement header) {
		this.header = header;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
