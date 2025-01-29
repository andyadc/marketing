package com.andyadc.dddframework.base.core.model;

import java.io.Serializable;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 3474561067666446797L;

	private String code;
	private String message;
	private T data;

	public Response() {
	}

	public Response(Builder<T> builder) {
		this.code = builder.code;
		this.message = builder.message;
		this.data = builder.data;
	}

	public static <T> Builder<T> builder() {
		return new Builder<>();
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

	@Override
	public String toString() {
		return "Response{" +
			"code=" + code +
			", message=" + message +
			", data=" + data +
			'}';
	}

	public static class Builder<T> {
		private String code;
		private String message;
		private T data;

		public Builder() {
		}

		public Response<T> build() {
			return new Response<>(this);
		}

		public Builder<T> code(String code) {
			this.code = code;
			return this;
		}

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}

		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}

	}

}
