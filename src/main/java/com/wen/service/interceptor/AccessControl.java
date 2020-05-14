package com.wen.service.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 提供方法级别的资源控制
 * 
 * @author wsy48420
 * @version $Id: AccessControl.java, v 0.1 2018年11月27日 下午5:19:19 wsy48420 Exp $
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