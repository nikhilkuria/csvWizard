package com.sc.csvCompare.bean;

import java.util.List;

public class HeaderElement {

	private List<String> headers;
	private List<Integer> keys;
	private boolean headerPresent;
	
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	public List<Integer> getKeys() {
		return keys;
	}
	public void setKeys(List<Integer> keys) {
		this.keys = keys;
	}
	public boolean isHeaderPresent() {
		return headerPresent;
	}
	public void setHeaderPresent(boolean headerPresent) {
		this.headerPresent = headerPresent;
	}
	
	
	
}
