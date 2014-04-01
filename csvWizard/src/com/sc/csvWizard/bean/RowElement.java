package com.sc.csvWizard.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sc.csvWizard.config.ConfigurationsStore;

public class RowElement {

	private List<String> rowEntries;
	private HeaderElement rowHeader;
	private int lineNumber;

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

	private List<String> getKeyAsList() {
		List<String> keys = new ArrayList<String>();
		if(ConfigurationsStore.keys.isEmpty()){
			keys = getRowEntries();
		}else{
			for (Integer key : ConfigurationsStore.keys) {
				keys.add(getRowEntries().get(key));
			}
		}

		return keys;
	}
	
	public String getKey() {
		if(ConfigurationsStore.considerOrder){
			return String.valueOf(getLineNumber());
		}
		return StringUtils.join(getKeyAsList(),ConfigurationsStore.csvDelimiter);
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

}
