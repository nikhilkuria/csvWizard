package com.sc.csvCompare.bean;

import java.util.List;

public class RowsCompliment {
	private List<RowElement> missingRows;
	private List<RowElement> extraRows;
	private MismatchRows mismatchRows;
	
	public List<RowElement> getMissingRows() {
		return missingRows;
	}
	public void setMissingRows(List<RowElement> missingRows) {
		this.missingRows = missingRows;
	}
	public List<RowElement> getExtraRows() {
		return extraRows;
	}
	public void setExtraRows(List<RowElement> extraRows) {
		this.extraRows = extraRows;
	}
	public MismatchRows getMismatchRows() {
		return mismatchRows;
	}
	public void setMismatchRows(MismatchRows mismatchRows) {
		this.mismatchRows = mismatchRows;
	}
}
