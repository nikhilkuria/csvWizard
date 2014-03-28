package com.sc.csvCompare.bean;

import java.util.List;

public class MismatchRow {

	private String key;
	private RowElement expectedRow;
	private RowElement actualRow;
	private List<Integer> mismatchIndices;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public RowElement getExpectedRow() {
		return expectedRow;
	}
	public void setExpectedRow(RowElement expectedRow) {
		this.expectedRow = expectedRow;
	}
	public RowElement getActualRow() {
		return actualRow;
	}
	public void setActualRow(RowElement actualRow) {
		this.actualRow = actualRow;
	}
	public List<Integer> getMismatchIndices() {
		return mismatchIndices;
	}
	public void setMismatchIndices(List<Integer> mismatchIndices) {
		this.mismatchIndices = mismatchIndices;
	}
	
}
