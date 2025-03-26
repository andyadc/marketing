package com.andyadc.marketing.types;

public enum ErrorCode {

	REMOTE_ERROR("999", "remote error!"),
	;

	private final String code;
	private final String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String code() {
		return code;
	}

	public String message() {
		return message;
	}

}
