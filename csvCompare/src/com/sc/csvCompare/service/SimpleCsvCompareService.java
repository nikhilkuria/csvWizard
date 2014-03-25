package com.sc.csvCompare.service;

import com.sc.csvCompare.bean.CompareOutput;
import com.sc.csvCompare.bean.CsvBean;
import com.sc.csvCompare.comapre.BeanComparer;
import com.sc.csvCompare.exception.ConfigNotFoundException;

public class SimpleCsvCompareService implements CsvCompareService {

	public CompareOutput compareCsvBeans(CsvBean expectedBean,
			CsvBean actualBean) throws ConfigNotFoundException {
		BeanComparer beanComparer = new BeanComparer();
		return beanComparer.compareBeans(expectedBean, actualBean);
	}

}
