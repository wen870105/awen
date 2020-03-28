package com.test.migu.singleton;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单例容器,非spring环境下使用,用class获取
 * 只有简单的注入和初始化功能
 * 支持循环引用
 * 部分逻辑参考和命名借鉴了springioc
 *
 * @author wen
 * @date 2020年3月26日
 */
public class SingletonContainer {

    private static final Logger logger = LoggerFactory.getLogger(SingletonContainer.class);
    //    private static Reflections reflections = new Reflections("com.migu.sgw");
    private Reflections reflections;

    private final Map<Class<?>, Object> singletonObjects = new ConcurrentHashMap<>(128);

    private final Map<Class<?>, Object> earlySingletonObjects = new HashMap<>(16);

    private final Set<Class<?>> singletonsCurrentlyInCreation = new HashSet<>(16);

    public SingletonContainer(String path) {
        // String path = "com.migu.sgw.comm.toolkit.singleton";
        reflections = new Reflections(path);
        init();
    }

    private void init() {
        Set<Class<?>> ret = reflections.getTypesAnnotatedWith(Singleton.class);
        ret.forEach(clazz -> {
            if (!clazz.isInterface()) {
                getBean2(clazz);
            }
        });
        logger.info("初始化[单例容器]组件:数量={},keys={}", singletonObjects.size(), singletonObjects.keySet().toString());
    }

    private <T> T getBean2(Class<T> clazz) {
        Object singleton = getSingleton(clazz);
        if (singleton == null) {
            Object obj = createInstance(clazz);
            singletonsCurrentlyInCreation.add(clazz);
            earlySingletonObjects.put(clazz, obj);
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> fClazz = field.getType();
                    field.setAccessible(true);
                    try {
                        field.set(obj, getBean2(fClazz));
                    } catch (IllegalAccessException e) {
                        logger.error("单例容器注入异常", e);
                        throw new RuntimeException("单例容器注入异常", e);
                    }
                }
            }
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Init.class)) {
                    method.setAccessible(true);
                    try {
                        method.invoke(obj, new Object[]{});
                    } catch (Exception e) {
                        logger.error("单例容器执行初始化方法异常,只支持无参数方法", e);
                        throw new RuntimeException("单例容器执行初始化方法异常,只支持无参数方法", e);
                    }
                }
            }
            singletonsCurrentlyInCreation.remove(clazz);
            earlySingletonObjects.remove(clazz);
            singletonObjects.put(clazz, obj);
            singleton = obj;
        }
        return (T) singleton;
    }

    private Object getSingleton(Class<?> beanName) {
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject == null && this.singletonsCurrentlyInCreation.contains(beanName)) {
            synchronized (this.singletonObjects) {
                singletonObject = this.earlySingletonObjects.get(beanName);
            }
        }
        return singletonObject;
    }


    private <T> T createInstance(Class<T> clazz) {
        try {
            T ret = clazz.newInstance();
            return ret;
        } catch (Exception e) {
            logger.error("", e);
            throw new RuntimeException("", e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> clazz) {
        T obj = (T) singletonObjects.get(clazz);
        if (obj == null) {
            logger.error("未注册类,{}", clazz.toString());
            throw new RuntimeException("未注册类," + clazz.toString());
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    public <T> Map<Class<?>, T> getBeansOfType(Class<T> clazz) {
        Map<Class<?>, T> result = new LinkedHashMap<>();
        singletonObjects.keySet().forEach(c -> {
            Object obj = singletonObjects.get(c);
            if (obj != null && clazz.isAssignableFrom(obj.getClass())) {
                result.put(c, (T) obj);
            }
        });
        return result;
    }
}
