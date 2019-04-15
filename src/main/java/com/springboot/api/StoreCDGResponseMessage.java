package com.springboot.api;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreCDGResponseMessage extends ResponseMessage {
	private List<String> errorCDG;
	private List<String> cdgArrary;
	private String calResult;
	
	public StoreCDGResponseMessage(List<String> errorCDG, List<String> cdgArrary, String calResult, int code, String message) {
		super(code, message);
		this.errorCDG = errorCDG;
		this.cdgArrary = cdgArrary;
		this.calResult = calResult;
	}

	@JsonProperty
	public List<String> getErrorCDG() {
		return errorCDG;
	}

	public void setErrorCDG(List<String> errorCDG) {
		this.errorCDG = errorCDG;
	}

	public List<String> getCdgArrary() {
		return cdgArrary;
	}

	public void setCdgArrary(List<String> cdgArrary) {
		this.cdgArrary = cdgArrary;
	}
	
	public String getCalResult(){
		return calResult;
	}
	
	public void setCalResult(String calResult){
		this.calResult = calResult;
	}

}
