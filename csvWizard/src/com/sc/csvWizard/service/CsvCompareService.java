package com.sc.csvWizard.service;

import com.sc.csvWizard.bean.CompareOutput;
import com.sc.csvWizard.bean.CsvBean;
import com.sc.csvWizard.exception.ConfigNotFoundException;

public interface CsvCompareService {

	public CompareOutput compareCsvBeans(CsvBean expectedBean, CsvBean actualBean) throws ConfigNotFoundException;
	
}
