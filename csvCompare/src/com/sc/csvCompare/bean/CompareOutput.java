package com.sc.csvCompare.bean;


public class CompareOutput {

	private RowsCompliment rowsCompliment;	
	private HeadersCompliment headersCompliment;
	private String expectedFileName;
	private String actualFileName;

	public RowsCompliment getRowsCompliment() {
		return rowsCompliment;
	}

	public void setRowsCompliment(RowsCompliment rowsCompliment) {
		this.rowsCompliment = rowsCompliment;
	}

	public HeadersCompliment getHeadersCompliment() {
		return headersCompliment;
	}

	public void setHeadersCompliment(HeadersCompliment headersCompliment) {
		this.headersCompliment = headersCompliment;
	}

	public String getExpectedFileName() {
		return expectedFileName;
	}

	public void setExpectedFileName(String expectedFileName) {
		this.expectedFileName = expectedFileName;
	}

	public String getActualFileName() {
		return actualFileName;
	}

	public void setActualFileName(String actualFileName) {
		this.actualFileName = actualFileName;
	}
	
	

}
