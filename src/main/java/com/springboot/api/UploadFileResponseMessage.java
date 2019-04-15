package com.springboot.api;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadFileResponseMessage extends ResponseMessage {
	private String threadUUID;
	private List<String> errorECG;

	public UploadFileResponseMessage(String threadUUID, List<String> errorECG,int code, String message) {
		super(code, message);
		this.threadUUID = threadUUID;
		this.errorECG = errorECG;
	}

	@JsonProperty
	public String getThreadUUID() {
		return threadUUID;
	}

	public void setThreadId(String threadUUID) {
		this.threadUUID = threadUUID;
	}

	@JsonProperty
	public List<String> getErrorECG() {
		return errorECG;
	}

	public void setErrorECG(List<String> errorECG) {
		this.errorECG = errorECG;
	}
}
