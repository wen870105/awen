package com.wen.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 * @author Wen
 *
 * @CreateDate 2016年9月12日
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BatisRepository {
}