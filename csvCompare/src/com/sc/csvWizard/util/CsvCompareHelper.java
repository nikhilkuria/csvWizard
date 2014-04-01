package com.sc.csvWizard.util;

import java.util.Collection;

import com.sc.csvWizard.config.ConfigurationsStore;
import com.sc.csvWizard.exception.ConfigNotFoundException;

public class CsvCompareHelper {

	public static void checkForConfigFile() throws ConfigNotFoundException{
		if(!ConfigurationsStore.configFileFound){
			throw new ConfigNotFoundException();
		}
	}
	
	public static boolean isNullorEmpty(Collection collection){
		return (collection==null) || collection.isEmpty();
	}
	
}
