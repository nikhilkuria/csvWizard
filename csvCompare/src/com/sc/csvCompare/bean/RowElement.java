package com.sc.csvCompare.bean;

import java.util.List;

public class RowElement {

	private List<String> rowEntries;
	private HeaderElement rowHeader;
	
	public List<String> getRowEntries() {
		return rowEntries;
	}
	
	public void setRowEntries(List<String> rowEntries) {
		this.rowEntries = rowEntries;
	}
	
	public HeaderElement getRowHeaders() {
		return rowHeader;
	}
	
	public void setRowHeaders(HeaderElement rowHeader) {
		this.rowHeader = rowHeader;
	}
	
	public boolean isHeaderPresent(){
		return rowHeader.isHeaderPresent();	
	}

}
