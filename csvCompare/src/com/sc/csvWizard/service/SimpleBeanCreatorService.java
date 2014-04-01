package com.sc.csvWizard.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.sc.csvWizard.bean.CsvBean;
import com.sc.csvWizard.bean.HeaderElement;
import com.sc.csvWizard.bean.RowElement;
import com.sc.csvWizard.exception.ConfigNotFoundException;
import com.sc.csvWizard.parser.CsvParser;

public class SimpleBeanCreatorService implements BeanCreatorService {

	public CsvBean getBeanFromCsv(File csvFile) throws FileNotFoundException, ConfigNotFoundException, IOException {
		CsvBean csvBean = new CsvBean();
		CsvParser csvParser = new CsvParser(csvFile);
		HeaderElement headerElement = csvParser.getHeaderRow();
		List<RowElement> rows = csvParser.getRows();
		csvBean.setHeader(headerElement);
		csvBean.setRows(rows);
		csvBean.setFileName(csvFile.getName());
		return csvBean;
	}

}
