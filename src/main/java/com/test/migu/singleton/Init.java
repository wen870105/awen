package com.test.migu.singleton;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author wen
 * @version 1.0
 * @date 2020/3/28 21:36
 */
@Target({METHOD})
@Retention(RUNTIME)
@Documented
public @interface Init {
}
