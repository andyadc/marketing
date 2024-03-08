package com.andyadc.marketing.base.web.auth.interceptor;

import com.andyadc.marketing.base.web.interceptor.BaseWebInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
