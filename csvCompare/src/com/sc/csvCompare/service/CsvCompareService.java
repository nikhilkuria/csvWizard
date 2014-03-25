package com.sc.csvCompare.service;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.CsvBean;
import com.sc.csvCompare.exception.ConfigNotFoundException;

public interface CsvCompareService {

	public CompareOutput compareCsvBeans(CsvBean expectedBean, CsvBean actualBean) throws ConfigNotFoundException;
	
}
