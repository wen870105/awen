package com.wen.util.singleton;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.spi.ValidationProvider;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wen.util.singleton.demo.ISing;
import com.wen.util.singleton.demo.TT;

/**
 * 单例容器,非spring环境下使用,用class获取
 * 
 * @author wen
 * @date 2020年3月26日
 */
public class SingletonContainer {

	private static final Logger logger = LoggerFactory.getLogger(ValidationProvider.class);
	private static Reflections reflections = new Reflections("com.wen.util.singleton");

	private final Map<Class<?>, Object> singletonObjects = new ConcurrentHashMap<>(128);

	private static SingletonContainer instance = new SingletonContainer();

	public static SingletonContainer getInstance() {
		return instance;
	}

	private SingletonContainer() {
		init();
	}

	private void init() {
		Set<Class<? extends ISingleton>> ret = reflections.getSubTypesOf(ISingleton.class);
		ret.forEach(clazz -> {
			try {
				if (!clazz.isInterface()) {
					ISingleton val = clazz.newInstance();
					singletonObjects.put(val.getClass(), val);
				}
			} catch (Exception e) {
				logger.error("", e);
			}
		});
		logger.info("初始化[单例容器]组件:数量={},keys={}", singletonObjects.size(), singletonObjects.keySet().toString());
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<T> clazz) {
		return (T) singletonObjects.get(clazz);
	}

	@SuppressWarnings("unchecked")
	public <T> Map<Class<?>, T> getBeansOfType(Class<T> clazzz) {
		Map<Class<?>, T> result = new LinkedHashMap<>();
		singletonObjects.keySet().forEach(c -> {
			Object obj = singletonObjects.get(c);
			if (obj != null && clazzz.isAssignableFrom(obj.getClass())) {
				result.put(c, (T) obj);
			}
		});
		return result;
	}

	public static void main(String[] args) {

		SingletonContainer ctx = SingletonContainer.getInstance();
		TT t1 = ctx.getBean(TT.class);
		System.out.println(JSON.toJSONString(t1));
		Map<Class<?>, ISing> map = ctx.getBeansOfType(ISing.class);
		System.out.println(JSON.toJSONString(map));

	}
}
