package com.sc.csvCompare.bean;

import java.util.List;

public class HeadersCompliment {

	List<String> expectedHeaders;
	List<String> actualHeaders;
	List<String> commonHeaders;
	List<String> missingHeaders;
	List<String> extraHeaders;
	public List<String> getExpectedHeaders() {
		return expectedHeaders;
	}
	public void setExpectedHeaders(List<String> expectedHeaders) {
		this.expectedHeaders = expectedHeaders;
	}
	public List<String> getActualHeaders() {
		return actualHeaders;
	}
	public void setActualHeaders(List<String> actualHeaders) {
		this.actualHeaders = actualHeaders;
	}
	public List<String> getCommonHeaders() {
		return commonHeaders;
	}
	public void setCommonHeaders(List<String> commonHeaders) {
		this.commonHeaders = commonHeaders;
	}
	public List<String> getMissingHeaders() {
		return missingHeaders;
	}
	public void setMissingHeaders(List<String> missingHeaders) {
		this.missingHeaders = missingHeaders;
	}
	public List<String> getExtraHeaders() {
		return extraHeaders;
	}
	public void setExtraHeaders(List<String> extraHeaders) {
		this.extraHeaders = extraHeaders;
	}
	
	
}
