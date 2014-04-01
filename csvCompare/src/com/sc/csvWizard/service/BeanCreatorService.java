package com.sc.csvWizard.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.sc.csvWizard.bean.CsvBean;
import com.sc.csvWizard.exception.ConfigNotFoundException;

public interface BeanCreatorService {

	public CsvBean getBeanFromCsv(File csvFile) throws FileNotFoundException, ConfigNotFoundException, IOException;
	
}
