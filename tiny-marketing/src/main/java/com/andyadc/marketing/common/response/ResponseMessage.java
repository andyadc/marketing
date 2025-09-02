package com.andyadc.marketing.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class ResponseMessage<T> implements Serializable {

	@Serial
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

}
