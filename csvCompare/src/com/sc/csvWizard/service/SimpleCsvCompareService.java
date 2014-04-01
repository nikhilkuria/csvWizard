package com.sc.csvWizard.service;

import com.sc.csvWizard.bean.CompareOutput;
import com.sc.csvWizard.bean.CsvBean;
import com.sc.csvWizard.comapre.BeanComparer;
import com.sc.csvWizard.exception.ConfigNotFoundException;

public class SimpleCsvCompareService implements CsvCompareService {

	public CompareOutput compareCsvBeans(CsvBean expectedBean,
			CsvBean actualBean) throws ConfigNotFoundException {
		BeanComparer beanComparer = new BeanComparer();
		return beanComparer.compareBeans(expectedBean, actualBean);
	}

}
