package com.sc.csvCompare.bean;

import java.util.List;
import java.util.Map;

public class MismatchRows {

	List<Integer> mismatchIndices;
	Map<Integer,Map<String,String>> mismatches;
	private List<Integer> keys;
	private boolean mismatch;
	
	public List<Integer> getMismatchIndices() {
		return mismatchIndices;
	}
	
	public void setMismatchIndices(List<Integer> mismatchIndices) {
		this.mismatchIndices = mismatchIndices;
	}
	
	public Map<Integer, Map<String, String>> getMismatches() {
		return mismatches;
	}
	
	public void setMismatches(Map<Integer, Map<String, String>> mismatches) {
		this.mismatches = mismatches;
	}

	public List<Integer> getKeys() {
		return keys;
	}

	public void setKeys(List<Integer> keys) {
		this.keys = keys;
	}

	public boolean isMismatch() {
		return mismatch;
	}

	public void setMismatch(boolean mismatch) {
		this.mismatch = mismatch;
	}
	
}
