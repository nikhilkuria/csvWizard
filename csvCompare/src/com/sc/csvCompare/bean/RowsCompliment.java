package com.sc.csvCompare.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sc.csvCompare.util.CsvCompareHelper;

public class RowsCompliment {
	private List<RowElement> missingRows;
	private List<RowElement> extraRows;
	private List<RowElement> commonRows;
	private List<MismatchRow> mismatchRows;
	
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
	public List<MismatchRow> getMismatchRow() {
		return mismatchRows;
	}
	public void setMismatchRow(List<MismatchRow> mismatchRows) {
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
	public List<String> getListofCommonRows(){
		List<String> extraRowsList = new ArrayList<String>();
		for (RowElement row : getCommonRows()) {
			extraRowsList.add(StringUtils.join(row.getRowEntries(), ","));
		}
		return extraRowsList;
	}
	public boolean isRowsMismatch(){
		if(CsvCompareHelper.isNullorEmpty(missingRows)&&CsvCompareHelper.isNullorEmpty(extraRows)&&CsvCompareHelper.isNullorEmpty(mismatchRows)){
			return false;
		}
			return true;
	}
	public List<RowElement> getCommonRows() {
		return commonRows;
	}
	public void setCommonRows(List<RowElement> commonRows) {
		this.commonRows = commonRows;
	}
}
