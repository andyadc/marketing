package com.andyadc.marketing.base.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 原生响应，注解了的 Controller 方法将不受 BaseRestControllerAdvice 控制，即不会在外自动包装 R 对象
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RawResponse {
}
