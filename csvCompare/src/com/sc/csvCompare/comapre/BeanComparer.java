package com.sc.csvCompare.comapre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.CsvBean;
import com.sc.csvCompare.bean.HeaderElement;
import com.sc.csvCompare.bean.HeadersCompliment;
import com.sc.csvCompare.bean.MismatchRow;
import com.sc.csvCompare.bean.RowElement;
import com.sc.csvCompare.bean.RowsCompliment;
import com.sc.csvCompare.config.ConfigurationsStore;
import com.sc.csvCompare.exception.ConfigNotFoundException;
import com.sc.csvCompare.util.CsvCompareHelper;

public class BeanComparer {
	
	public CompareOutput compareBeans(CsvBean expectedBean, CsvBean actualBean)
			throws ConfigNotFoundException {
		CsvCompareHelper.checkForConfigFile();
		CompareOutput output = new CompareOutput();

		if (ConfigurationsStore.compareHeaders) {
			HeadersCompliment headersCompliment = validateHeaders(
					expectedBean.getHeader(), actualBean.getHeader());
			output.setHeadersCompliment(headersCompliment);
		}

		RowsCompliment rowsCompliment = fetchRowsCompliment(
				expectedBean, actualBean);
		output.setRowsCompliment(rowsCompliment);
		output.setActualFileName(actualBean.getFileName());
		output.setExpectedFileName(expectedBean.getFileName());
		return output;
	}

	private RowsCompliment fetchRowsCompliment(CsvBean expectedBean, CsvBean actualBean) {
		RowsCompliment rowsCompliment = new RowsCompliment();
		List<RowElement> missingRows = getDeltaRows(expectedBean,actualBean);
		List<RowElement> extraRows = getDeltaRows(actualBean,expectedBean); 
		List<RowElement> commonRows = getCommonRows(actualBean,expectedBean);
		List<MismatchRow> mismatchRows = getMismatchRows(actualBean,expectedBean);
		rowsCompliment.setExtraRows(extraRows);
		rowsCompliment.setMissingRows(missingRows);
		rowsCompliment.setCommonRows(commonRows);
		rowsCompliment.setMismatchRow(mismatchRows);
		return rowsCompliment;
	}

	private List<MismatchRow> getMismatchRows(CsvBean actualBean,
			CsvBean expectedBean) {
		
		List<MismatchRow> mismatchRows = new ArrayList<MismatchRow>();		
		
		Map<String,RowElement> actualRows = actualBean.getRowsMap();
		Map<String,RowElement> expectedRows = expectedBean.getRowsMap();
		
		for (String expectedKey : expectedRows.keySet()) {
			RowElement expectedRow = expectedRows.get(expectedKey);
			RowElement actualRow = actualRows.get(expectedKey);
			if(actualRow!=null){
				MismatchRow mismatchRow = checkForMismatch(expectedRow, actualRow);
				if(!mismatchRow.getMismatchIndices().isEmpty()){
					mismatchRows.add(mismatchRow);
				}			
			}

		}
		return mismatchRows;
	}

	private MismatchRow checkForMismatch(RowElement expectedRow,
			RowElement actualRow) {
		MismatchRow mismatchRow = new MismatchRow();
		normalizeRowWidths(expectedRow,actualRow);
		List<String> expectedEntries = expectedRow.getRowEntries();
		List<String> actualEntries = actualRow.getRowEntries();
		List<Integer> mismatchIndices = new ArrayList<Integer>();
		
		mismatchRow.setExpectedRow(expectedRow);
		mismatchRow.setActualRow(actualRow);
		mismatchRow.setKey(expectedRow.getKey());
		
		for (int index = 0; index < expectedEntries.size(); index++) {
			
			if(actualEntries.size()<=index){
				mismatchIndices.add(index);
				continue;
			}
			if(!expectedEntries.get(index).equals(actualEntries.get(index))){
				mismatchIndices.add(index);
				continue;
			}
		}
			
		mismatchRow.setMismatchIndices(mismatchIndices);
		
		return mismatchRow;
	}

	private void normalizeRowWidths(RowElement expectedRow, RowElement actualRow) {
		List<String> expectedRowEntries = new ArrayList<String>();
		expectedRowEntries.addAll(expectedRow.getRowEntries());
		int expectedRowSize = expectedRowEntries.size();
		List<String> actualRowEntries = new ArrayList<String>();
		actualRowEntries.addAll(actualRow.getRowEntries());
		int actualRowSize = actualRowEntries.size();
		int width = Math.max(expectedRowSize, actualRowSize);
		
		for (int index = expectedRowSize; index < width; index++) {
			expectedRowEntries.add("");
		}
		for (int index = actualRowSize; index < width; index++) {
			actualRowEntries.add("");
		}
		expectedRow.setRowEntries(expectedRowEntries);
		actualRow.setRowEntries(actualRowEntries);
	}

	private List<RowElement> getCommonRows(CsvBean actualBean,
			CsvBean expectedBean) {
		List<RowElement> commonRows = new ArrayList<RowElement>();		
		
		Map<String,RowElement> actualRows = actualBean.getRowsMap();
		Map<String,RowElement> expectedRows = expectedBean.getRowsMap();
		
		for (String expectedKey : expectedRows.keySet()) {
			RowElement expectedRow = expectedRows.get(expectedKey);
			RowElement actualRow = actualRows.get(expectedKey);
			if(actualRow!=null){
				if(CollectionUtils.disjunction(expectedRow.getRowEntries(), actualRow.getRowEntries()).isEmpty()){
					commonRows.add(expectedRow);
				}
			}

		}
		return commonRows;
	}

	private List<RowElement> getDeltaRows(CsvBean expectedBean, CsvBean actualBean) {
		List<RowElement> deltaRows = new ArrayList<RowElement>();
		
		Map<String,RowElement> actualRows = actualBean.getRowsMap();
		Map<String,RowElement> expectedRows = expectedBean.getRowsMap();
		
		for (String expectedKey : expectedRows.keySet()) {
			RowElement expectedRow = expectedRows.get(expectedKey);
			RowElement actualRow = actualRows.get(expectedKey);
			if(actualRow==null){
				deltaRows.add(expectedRow);
			}
		}
		return deltaRows;
	}

	private HeadersCompliment validateHeaders(HeaderElement expectedHeader,
			HeaderElement actualHeader) {
		
		HeadersCompliment headersCompliment = new HeadersCompliment();
		List<String> expectedHeaders = expectedHeader.getHeaders();
		List<String> actualHeaders = actualHeader.getHeaders();

		headersCompliment.setMissingHeaders(new ArrayList<String>(
				CollectionUtils.removeAll(expectedHeaders, actualHeaders)));
		headersCompliment.setExtraHeaders(new ArrayList<String>(CollectionUtils
				.removeAll(actualHeaders,expectedHeaders)));
		headersCompliment.setCommonHeaders(new ArrayList<String>(
				CollectionUtils.intersection(expectedHeaders, actualHeaders)));
		headersCompliment.setActualHeaders(actualHeaders);
		headersCompliment.setExpectedHeaders(expectedHeaders);

		return headersCompliment;

	}

}
