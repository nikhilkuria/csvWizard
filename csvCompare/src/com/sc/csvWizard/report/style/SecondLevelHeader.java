package com.sc.csvWizard.report.style;

import com.sc.csvWizard.report.helper.ReportVariables;

public class SecondLevelHeader implements SectionStyle {

	@Override
	public String getFontSize() {
		// TODO Auto-generated method stub
		return "15";
	}

	@Override
	public String getFontColor() {
		// TODO Auto-generated method stub
		return ReportVariables.DARK_COLOR_BLUE;
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
