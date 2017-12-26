package com.wen.service.cache;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 缓存
 * @author Wen
 * @CreatDate: 2016年4月21日
 */
@Service("jedisCacheService")
public class JedisCacheServiceImpl implements JedisCacheService {
	@Resource
	private Cache cache;

	private static JedisCacheService instance;
	
	public static JedisCacheService getInstance() {
		return instance;
	}
	
	@PostConstruct
	private void init(){
		instance = this;
	}

	@Override
	public boolean isExists(String key) {
		return cache.isExists(key);
	}

	@Override
	public boolean expire(String key, int seconds) {
		return cache.expire(key, seconds);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Class<T> clazz) {
		if(String.class.getName().equalsIgnoreCase(clazz.getName())){
			return (T)cache.get(key);
		}
		return cache.get(key, clazz);
	}

	@Override
	public Object get(String key) {
		return cache.get(key);
	}

	@Override
	public boolean del(String... keys) {
		return cache.del(keys);
	}

	@Override
	public boolean set(String key, Object value) {
		return cache.set(key, value);
	}

	@Override
	public boolean set(String key, Object value, int secs) {
		return  cache.set(key, value, secs);
	}

	@Override
	public boolean setnx(String key, String value) {
		return cache.setnx(key, value);
	}

	@Override
	public boolean setnx(String key, Object value, int secs) {
		if(cache.setnx(key, value)){
			cache.expire(key, secs);
		}else{
			return false;
		}
		
		return true;
	}

	@Override
	public <T> T hget(String key, String field, Class<T> clazz) {
		return cache.hget(key, field, clazz);
	}

	@Override
	public boolean hset(String key, String field, Object value) {
		return cache.hset(key, field, value,null);
	}
	
	@Override
	public boolean hset(String key, String field, Object value, int secs) {
		return cache.hset(key, field, value,secs);
	}

	@Override
	public Long hdel(String key, String... fields){
		return cache.hdel(key, fields);
	}
}
