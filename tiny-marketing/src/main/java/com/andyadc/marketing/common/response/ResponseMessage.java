package com.andyadc.marketing.common.response;

import java.io.Serializable;

public class ResponseMessage<T> implements Serializable {

	private static final long serialVersionUID = -1771704121799168969L;

	private String code;
	private String message;
	private T data;

	public ResponseMessage() {
	}

	public ResponseMessage(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponseMessage(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
