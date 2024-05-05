package com.andyadc.dddframework.base.web.interceptor;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;

public abstract class BaseWebInterceptor implements HandlerInterceptor, Ordered {

	public String[] pathPatterns() {
		return new String[]{"/**"};
	}

	public String[] excludePathPatterns() {
		return new String[]{"/error"};
	}
}
