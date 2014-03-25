package com.sc.csvCompare.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigurationsManager {

	public static void initializeManager(File configFile) throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		
		properties.load(new FileInputStream(configFile));
		
		setProperties(properties);
	}

	private static void setProperties(Properties properties) {
		
		ConfigurationsStore.caseSensitiveContent = properties.getProperty(ConfigurationConstants.CASE_SENSITIVE_CONTENT).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.caseSensitiveHeader = properties.getProperty(ConfigurationConstants.CASE_SENSITIVE_HEADERS).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.compareHeaders = properties.getProperty(ConfigurationConstants.COMPARE_HEADERS).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.headersPresent = properties.getProperty(ConfigurationConstants.HEADERS_PRESENT).equals(ConfigurationConstants.CONFIG_TRUE);
		ConfigurationsStore.keys = prepareKeys(properties.getProperty(ConfigurationConstants.UNIQUE_KEY));
		ConfigurationsStore.csvDelimiter = properties.getProperty(ConfigurationConstants.CSV_DELIMITER);

		ConfigurationsStore.configFileFound = true;
	}

	private static List<Integer> prepareKeys(String property) {
		List<Integer> keyList = new ArrayList<Integer>();
		List<String> keyStringList = Arrays.asList(property.split(","));
		for (String key : keyStringList) {
			keyList.add(Integer.valueOf(key));
		}
		return keyList;
	}
	
}
