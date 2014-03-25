package com.sc.csvCompare.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.sc.csvCompare.bean.CsvBean;
import com.sc.csvCompare.bean.HeaderElement;
import com.sc.csvCompare.bean.RowElement;
import com.sc.csvCompare.exception.ConfigNotFoundException;
import com.sc.csvCompare.parser.CsvParser;

public class SimpleBeanCreatorService implements BeanCreatorService {

	public CsvBean getBeanFromCsv(File csvFile) throws FileNotFoundException, ConfigNotFoundException, IOException {
		CsvBean csvBean = new CsvBean();
		CsvParser csvParser = new CsvParser(csvFile);
		HeaderElement headerElement = csvParser.getHeaderRow();
		List<RowElement> rows = csvParser.getRows();
		csvBean.setHeader(headerElement);
		csvBean.setRows(rows);
		return csvBean;
	}

}
