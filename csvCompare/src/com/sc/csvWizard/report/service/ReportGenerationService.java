package com.sc.csvWizard.report.service;

import java.io.IOException;

import com.sc.csvWizard.bean.CompareOutput;

public interface ReportGenerationService {

	public String generateReport(CompareOutput output) throws IOException;
}
