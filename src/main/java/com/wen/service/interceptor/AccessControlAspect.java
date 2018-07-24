package com.wen.service.interceptor;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.wen.web.IndexAction;

/**
 * @version 1.0.0
 * @author: zhangyk
 * @date: 2017/9/15 23:10
 * @descrpiton:
 */
@Aspect
@Service
public class AccessControlAspect implements ApplicationContextAware{
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Around("@annotation(accessControl)")
    public Object process(ProceedingJoinPoint pjp, AccessControl accessControl) throws Throwable {

//        String resource = accessControl.resource();
//        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
//        String controllerName = accessControl.controller();
//        if(StringUtils.isEmpty(controllerName)){
//        	logger.warn("not set controller!continue process!method:{}!",methodSignature.toString());
//            return pjp.proceed();
//        }
        System.out.println("hahahahahah");
        pjp.proceed();
        return null;

//        AccessController accessController = applicationContext.getBean(controllerName, AccessController.class);
//        if( accessController == null ){
//            log.warn("not found controller bean!controller name:{}!",controllerName);
//            return pjp.proceed();
//        }
//        Method method = methodSignature.getMethod();

//        return new AccessControlTemplate() {
//
//            @Override
//            public Object unSurpassLimitProcess(SurpassLimitCheckResult surpassLimitCheckResult) throws Throwable {
//                return pjp.proceed();
//            }
//
//            @Override
//            public Object surpassLimitProcess(SurpassLimitCheckResult surpassLimitCheckResult) throws Throwable{
//                return accessController.doCallback(pjp.getTarget(),method,pjp.getArgs(),surpassLimitCheckResult);
//            }
//        }.access(resource,accessController.fetchCondition(pjp.getTarget(),method,pjp.getArgs(),resource));
    }
}
