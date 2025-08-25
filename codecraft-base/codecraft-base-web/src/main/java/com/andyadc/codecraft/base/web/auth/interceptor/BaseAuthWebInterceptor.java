package com.andyadc.codecraft.base.web.auth.interceptor;

import com.andyadc.codecraft.base.web.interceptor.BaseWebInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BaseAuthWebInterceptor extends BaseWebInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return false;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
