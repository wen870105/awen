package com.wen.service.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0.0
 * @author: zhangyk
 * @date: 2017/9/13 21:35
 * @descrpiton: 提供方法级别的资源控制
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AccessControl {

	/**
	 * 资源名称
	 *
	 * @return
	 */
	String resource();

	/**
	 * 访问控制器bean名称,需要实现AccessController接口
	 */
	String controller() default "";
}