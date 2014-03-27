package com.sc.csvCompare.report.style;

import com.sc.csvCompare.report.helper.ReportVariables;

public class HeaderCompareHeaderStyle implements SectionStyle{

	@Override
	public String getFontSize() {		
		return "22";
	}

	@Override
	public String getFontColor() {
		// TODO Auto-generated method stub
		return ReportVariables.HEADER_COMPARE_HEADER_COLOR;
	}

	@Override
	public String getBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlignment() {
		// TODO Auto-generated method stub
		return "left";
	}

	@Override
	public String getFontWeight() {
		// TODO Auto-generated method stub
		return "normal";
	}

	@Override
	public String getVerticalAlign() {
		// TODO Auto-generated method stub
		return "top";
	}

}
