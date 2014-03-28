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
	}

	private static void setPropertiesForCompare(Properties properties) {
		
		ConfigurationsStore.caseSensitiveContent = properties.getProperty(ConfigurationConstants.CASE_SENSITIVE_CONTENT).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.caseSensitiveHeader = properties.getProperty(ConfigurationConstants.CASE_SENSITIVE_HEADERS).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.compareHeaders = properties.getProperty(ConfigurationConstants.COMPARE_HEADERS).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.headersPresent = properties.getProperty(ConfigurationConstants.HEADERS_PRESENT).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.csvDelimiter = properties.getProperty(ConfigurationConstants.CSV_DELIMITER);

		List<String> keyList = Arrays.asList(properties.getProperty(ConfigurationConstants.UNIQUE_KEY).split(","));
		
		for (String key : keyList) {
			int keyVal = Integer.valueOf(key);
			if(!ConfigurationConstants.NO_UNIQUE_KEY.equals(key)){
				keyVal--;
				ConfigurationsStore.keys.add(keyVal);
			}			
		}	
		
		ConfigurationsStore.configFileFound = true;
	}
	
}
