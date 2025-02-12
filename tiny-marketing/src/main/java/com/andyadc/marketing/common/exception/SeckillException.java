package com.andyadc.marketing.common.exception;

import com.andyadc.marketing.common.ErrorCode;

public class SeckillException extends RuntimeException {

	private static final long serialVersionUID = 6072087408074461087L;

	private String code;

	public SeckillException(ErrorCode errorCode) {
		this(errorCode.code(), errorCode.message());
	}

	public SeckillException(ErrorCode errorCode, Throwable cause) {
		this(errorCode.code(), errorCode.message(), cause);
	}

	public SeckillException(String code, String messgae) {
		super(messgae);
		this.code = code;
	}

	public SeckillException(String code, String messgae, Throwable cause) {
		super(messgae, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
