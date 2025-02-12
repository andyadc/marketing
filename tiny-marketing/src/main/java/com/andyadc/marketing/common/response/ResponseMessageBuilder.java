package com.andyadc.marketing.common.response;

import com.andyadc.marketing.common.ErrorCode;

public final class ResponseMessageBuilder {

	public static <T> ResponseMessage<T> success(T body) {
		return build(ErrorCode.SUCCESS.code(), ErrorCode.SUCCESS.message(), body);
	}

	public static <T> ResponseMessage<T> build(String code, String message) {
		return build(code, message, null);
	}

	public static <T> ResponseMessage<T> build(String code, String message, T body) {
		return new ResponseMessage<T>(code, message, body);
	}

	public static <T> ResponseMessage<T> build(String code) {
		return new ResponseMessage<T>(code);
	}
}
