package com.sc.csvWizard.report.helper;

import java.util.Map;

import com.sc.csvWizard.report.style.SectionStyle;

public class ReportCssHelper {

	public static String reportHeaderStyle = "color:#FF6600;text-align:center;font-weight:bold;font-size:30";
	public static String fileNameStyle = "color:#000000;text-align:left;font-weight:bold;font-size:15";
	public static String standardInfoStyle = "color:#6C6C75;text-align:left;font-style:italic;font-size:13";
	
	public static String getStyleStringFromMap(Map<String,String> styleMap){
		StringBuilder styleStringBuilder = new StringBuilder();
		for (String propertyName : styleMap.keySet()) {
			styleStringBuilder.append(propertyName + ":" + styleMap.get(propertyName) + ";");
		}
		return styleStringBuilder.toString();
	}


	public static String getStyleString(SectionStyle headerStyle) {
		String style = "color:"+headerStyle.getFontColor()+";text-align:"+headerStyle.getAlignment()+
				";font-style:"+headerStyle.getFontWeight()+";font-size:"+headerStyle.getFontSize()+
				";vertical-align:"+headerStyle.getVerticalAlign();
		return style;
	}
	
}
