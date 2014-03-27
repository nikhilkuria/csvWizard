package com.sc.csvCompare.config;

import java.util.List;

public class ConfigurationsStore {

	public static boolean configFileFound;
	
	public static boolean headersPresent;
	public static boolean compareHeaders;
	public static boolean caseSensitiveHeader;
	public static boolean caseSensitiveContent;
	
	public static String csvDelimiter;
	
	public static List<Integer> keys = null;
	
	public static String reportLocation;
	public static boolean colorMapping;
	public static boolean showCommonHeaders;
	public static boolean showCommonRows;
}
