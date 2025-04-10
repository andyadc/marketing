package com.andyadc.marketing.common;

public enum ErrorCode {

	SUCCESS("0000", "成功"),
	FAILURE("2001", "失败"),
	PARAMS_INVALID("2002", "参数错误"),
	USERNAME_IS_NULL("2003", "用户名不能为空"),
	PASSWORD_IS_NULL("2004", "密码不能为空"),
	USERNAME_IS_ERROR("2005", "用户名错误"),
	PASSWORD_IS_ERROR("2006", "密码错误"),
	SERVER_EXCEPTION("2007", "服务器异常"),
	STOCK_LT_ZERO("2008", "库存不足"),
	GOODS_NOT_EXISTS("2009", "当前商品不存在"),
	ACTIVITY_NOT_EXISTS("2010", "当前活动不存在"),
	BEYOND_LIMIT_NUM("2011", "下单数量不能超过限购数量"),
	USER_NOT_LOGIN("2012", "用户未登录"),
	TOKEN_EXPIRE("2013", "Token失效"),
	DATA_PARSE_FAILED("2014", "数据解析失败"),
	SERIALIZATION_ERROR("2015", "数据解析失败");

	private final String code;
	private final String mesaage;

	ErrorCode(String code, String mesaage) {
		this.code = code;
		this.mesaage = mesaage;
	}

	public String code() {
		return code;
	}

	public String message() {
		return mesaage;
	}
}
