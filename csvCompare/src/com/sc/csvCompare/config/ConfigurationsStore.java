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
}
