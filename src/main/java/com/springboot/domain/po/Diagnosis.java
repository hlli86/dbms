package com.springboot.domain.po;

public class Diagnosis {
	private String testId;
	private String cdgResults;
	private String  ecgTag;
	
	public Diagnosis() {
		
	}
	
	public Diagnosis(String testId, String cdgReaults, String ecgTag) {
		this.testId = testId;
		this.cdgResults = cdgReaults;
		this.ecgTag = ecgTag;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getCdgResults() {
		return cdgResults;
	}

	public void setCdgResults(String cdgResults) {
		this.cdgResults = cdgResults;
	}

	public String  getEcgTag() {
		return ecgTag;
	}

	public void setEcgTag(String ecgTag) {
		this.ecgTag = ecgTag;
	}
}
