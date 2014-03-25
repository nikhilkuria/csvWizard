package com.sc.csvCompare.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sc.csvCompare.bean.CsvBean;
import com.sc.csvCompare.exception.ConfigNotFoundException;

public interface BeanCreatorService {

	public CsvBean getBeanFromCsv(File csvFile) throws FileNotFoundException, ConfigNotFoundException, IOException;
	
}
