package com.sc.csvCompare.exception;

public class ConfigNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ConfigNotFoundException(){
		super();
	}
	
	@Override
	public String getMessage() {
		return "The configuration file has not been set.";
	}
	
	

}
