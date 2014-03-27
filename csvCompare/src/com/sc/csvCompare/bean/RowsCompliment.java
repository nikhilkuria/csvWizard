package com.sc.csvCompare.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
	public List<String> getListofMissingRows(){
		List<String> missingRowsList = new ArrayList<String>();
		for (RowElement row : getMissingRows()) {
			missingRowsList.add(StringUtils.join(row.getRowEntries(), ","));
		}
		return missingRowsList;
	}
	public List<String> getListofExtraRows(){
		List<String> extraRowsList = new ArrayList<String>();
		for (RowElement row : getExtraRows()) {
			extraRowsList.add(StringUtils.join(row.getRowEntries(), ","));
		}
		return extraRowsList;
	}
}
