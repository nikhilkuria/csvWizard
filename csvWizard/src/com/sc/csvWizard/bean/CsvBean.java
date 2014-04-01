package com.sc.csvWizard.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,RowElement> getRowsMap(){
		Map<String,RowElement> rowMap = new HashMap<String,RowElement>();
		for (RowElement rowElement : rows) {
			rowMap.put(rowElement.getKey(), rowElement);
		}
		return rowMap;
	}
}
