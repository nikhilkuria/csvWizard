package com.sc.csvCompare.bean;

import java.util.List;

public class CsvBean {

	private List<RowElement> rows;
	private HeaderElement header;
	
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
	
}
