package com.sc.csvCompare.report.style;

import com.sc.csvCompare.report.helper.ReportVariables;

public class InfoHeader implements SectionStyle {

	@Override
	public String getFontSize() {
		// TODO Auto-generated method stub
		return "15";
	}

	@Override
	public String getFontColor() {
		// TODO Auto-generated method stub
		return ReportVariables.HEADER_NORMAL_COLOR_DARK_BLUE;
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
		return "bold";
	}

	@Override
	public String getVerticalAlign() {
		// TODO Auto-generated method stub
		return "top";
	}

}
