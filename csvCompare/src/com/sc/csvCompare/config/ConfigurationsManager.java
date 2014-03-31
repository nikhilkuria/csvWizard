package com.sc.csvCompare.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigurationsManager {

	public static void initializeManager(File configFile) throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		
		properties.load(new FileInputStream(configFile));
		
		setPropertiesForCompare(properties);
		setPropertiesForReport(properties);
	}

	private static void setPropertiesForReport(Properties properties) {
		ConfigurationsStore.reportLocation = properties.getProperty(ConfigurationConstants.REPORT_LOCATION);
		ConfigurationsStore.colorMapping = properties.getProperty(ConfigurationConstants.COLOR_MAPPING).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.showCommonHeaders = properties.getProperty(ConfigurationConstants.SHOW_COMMON_HEADERS).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.showCommonRows = properties.getProperty(ConfigurationConstants.SHOW_COMMON_ROWS).equals(ConfigurationConstants.CONFIG_TRUE);	
		ConfigurationsStore.showLineNumbers = properties.getProperty(ConfigurationConstants.SHOW_LINE_NUMBERS).equals(ConfigurationConstants.CONFIG_TRUE);
	}

	private static void setPropertiesForCompare(Properties properties) {
		
		ConfigurationsStore.compareHeaders = properties.getProperty(ConfigurationConstants.COMPARE_HEADERS).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.headersPresent = properties.getProperty(ConfigurationConstants.HEADERS_PRESENT).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.csvDelimiter = properties.getProperty(ConfigurationConstants.CSV_DELIMITER);

		setCompareStrategy(properties);	
		
		ConfigurationsStore.configFileFound = true;
	}

	private static void setCompareStrategy(Properties properties) {
		List<String> keyList = Arrays.asList(properties.getProperty(ConfigurationConstants.UNIQUE_KEY).split(","));
		boolean considerOrder =  properties.getProperty(ConfigurationConstants.CONSIDER_ORDER).equals(ConfigurationConstants.CONFIG_TRUE);
		boolean uniqueKey = !keyList.contains(ConfigurationConstants.NO_UNIQUE_KEY);
		if(uniqueKey){			
			for (String key : keyList) {
				int keyVal = Integer.valueOf(key);
				if(!ConfigurationConstants.NO_UNIQUE_KEY.equals(key)){
					keyVal--;
					ConfigurationsStore.keys.add(keyVal);
				}			
			}
			considerOrder = false;
		}
		ConfigurationsStore.considerOrder = considerOrder;
		
	}
	
}
