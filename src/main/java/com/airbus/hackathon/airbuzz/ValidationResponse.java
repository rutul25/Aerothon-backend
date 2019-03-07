package com.airbus.hackathon.airbuzz;

public class ValidationResponse {

	private boolean result;
	private String comment;
	
	public ValidationResponse(boolean result, String comment) {
		super();
		this.result = result;
		this.comment = comment;
	}
	
	public ValidationResponse() {
		super();
	}

	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
