package com.wen.util.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.alibaba.fastjson.JSON;
/**
 * 
 * @author Wen
 * @CreatDate: 2016年4月21日
 */
@Service("jedisCache")
public class JedisCache implements Cache {

    private final static Log LOGGER = LogFactory.getLog(JedisCache.class);
    @Resource(name="shardedJedisPool")  
    private ShardedJedisPool jedisPool; // 池化管理jedis链接池

    private Integer selectDB = 1;
    
    public JedisCache(){
    }

    /**
     * key 前缀规则
     */
    private String keyPreRule = null;

    private ShardedJedis getJedis() {
        try{
            ShardedJedis jedis = jedisPool.getResource();
            Iterator<Jedis> it = jedis.getAllShards().iterator();
            while (it.hasNext()) {
                Jedis j = it.next();
                j.select(selectDB);
            }
            return jedis;
        }catch(Exception e){
        	 throw new RuntimeException("无法连接Redis", e);
        }
    }

    private void returnJedis(ShardedJedis jedis) {
    	
        if (jedis != null) {
        	jedis.close();
//            jedisPool.returnResourceObject(jedis);
        }
    }

    /**
     * 向redis里面添加key-value格式的数据
     *
     * @param key key
     * @param value value
     */

    @Override
	public boolean set(String key, String value) {
        if (!isValidKey(key)) {
            return false;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
            LOGGER.error("[Jedis]set key(" + key + "),value(" + value + "),error", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 向redis里面添加key-value格式的数据+过期时间(s)
     * @param key
     * @param value
     * @param secs
     * @return
     */
    @Override
	public boolean set(String key, String value, int secs) {
        if (!isValidKey(key)) {
            return false;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
            // jedis.set(key, value, "NX", "EX",
            // secs);//NX:key在缓存中不存在才设置,EX:seconds,secs:过期时间
            jedis.expire(key, secs);
            return true;
        } catch (Exception e) {
            LOGGER.error("[Jedis]set key(" + key + "),value(" + value + "),secs(" + secs + ") error", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 向缓存中设置对象
     *
     * @param key
     * @param value
     * @return
     */
    @Override
	public boolean set(String key, Object value) {
        if (!isValidKey(key)) {
            return false;
        }
        ShardedJedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = getJedis();
            jedis.set(key, objectJson);
            return true;
        } catch (Exception e) {
            LOGGER.error("[Jedis]set key(" + key + "),value(" + value + "),error", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 向缓存中设置对象+过期时间(s)
     *
     * @param key
     * @param value
     * @param secs
     * @return
     */
    @Override
	public boolean set(String key, Object value, int secs) {
        if (!isValidKey(key)) {
            return false;
        }
        ShardedJedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = getJedis();
            jedis.set(key, objectJson);
            jedis.expire(key, secs);
            return true;
        } catch (Exception e) {
            LOGGER.error("[Jedis]set key(" + key + "),value(" + value + "),secs(" + secs + ") error", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 在key不存在的情况下设置其值为value。
     * 
     * @param key
     * @param value
     * @return
     */
    @Override
	public boolean setnx(String key, Object value) {
        if (!isValidKey(key)) {
            return false;
        }
        ShardedJedis jedis = null;
        try {
            String objectJson = JSON.toJSONString(value);
            jedis = getJedis();
            Long result = jedis.setnx(key, objectJson);
            return result != null && result == 1;
        } catch (Exception e) {
            LOGGER.error("[Jedis]setnx key(" + key + "),value(" + value + "),error", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 删除缓存中得对象，根据key
     *
     * @param key
     * @return
     */
    @Override
	public boolean del(String... keys) {
        if (keys == null || keys.length == 0) {
            return true;
        }
        boolean ret = true;
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            for (String key : keys) {
                if (!isValidKey(key)) {
                    ret = false;
                    break;
                }
                jedis.del(key);
            }
        } catch (Exception e) {
            LOGGER.error("[Jedis]del key(" + keys + "),error", e);
            ret = false;
        } finally {
            returnJedis(jedis);
        }
        return ret;
    }

    /**
     * 根据key 获取内容
     *
     * @param key
     * @return
     */
    @Override
	public Object get(String key) {
        if (!isValidKey(key)) {
            return null;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            Object value = jedis.get(key);
            return value;
        } catch (Exception e) {
            LOGGER.error("[Jedis]get key(" + key + "),error", e);
            return null;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 获取Long类型的key。
     * 
     * @param key
     * @return
     */
    @Override
	public Long getLong(String key) {
        Long value = 0L;
        String str = (String) get(key);
        if (StringUtils.isNumeric(str)) {
            value = Long.parseLong(str);
        }
        return value;
    }

    /**
     * 获取字符串类型的值
     * @param key
     * @return
     */
    @Override
	public String getString(String key) {
        if (!isValidKey(key)) {
            return null;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.get(key);
        } catch (Exception e) {
            LOGGER.error("[Jedis]get key(" + key + "),error", e);
            return null;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 根据key 获取对象
     *
     * @param key
     * @return
     */
    @Override
	public <T> T get(String key, Class<T> clazz) {
        if (!isValidKey(key)) {
            return null;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            String value = jedis.get(key);
            return JSON.parseObject(value, clazz);
        } catch (Exception e) {
            LOGGER.error("[Jedis]get key(" + key + "),class(" + clazz.toString() + "),error", e);
            return null;
        } finally {
            returnJedis(jedis);
        }
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。 当 key 存在但不是字符串类型时，返回一个错误。
     * @param key
     * @param value
     * @param clazz
     * @return
     */
    @Override
	public <T> T getSet(String key, Object value, Class<T> clazz) {
        if (!isValidKey(key)) {
            return null;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            String objectJson = JSON.toJSONString(value);
            String ret = jedis.getSet(key, objectJson);
            return JSON.parseObject(ret, clazz);
        } catch (Exception e) {
            LOGGER.error(
                    "[Jedis]get key(" + key + "),value(" + value + "),class(" + clazz.toString() + "),error",
                    e);
            return null;
        } finally {
            returnJedis(jedis);
        }
    }

    @Override
	public Long incr(String key) {
        if (!isValidKey(key)) {
            return 0L;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.incr(key);
        } catch (Exception e) {
            LOGGER.error("[Jedis]incr key(" + key + "),error", e);
            return 0L;
        } finally {
            returnJedis(jedis);
        }
    }

    @Override
	public Long incr(String key, int ttl) {
        if (!isValidKey(key)) {
            return 0L;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            Long count = jedis.incr(key);
            if (count == 1) {
                jedis.expire(key, ttl);
            }
            return count;
        } catch (Exception e) {
            LOGGER.error("[Jedis]incr key(" + key + "),secs(" + ttl + "),error", e);
            return 0L;
        } finally {
            returnJedis(jedis);
        }
    }

    @Override
	public void incrBy(String key, long value, int ttl) {
        if (!isValidKey(key)) {
            return;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            Long count = jedis.incrBy(key, value);
            if (count == value) {
                jedis.expire(key, ttl);
            }
        } catch (Exception e) {
            LOGGER.error("[Jedis]incrBy key(" + key + "),value(" + value + "),secs(" + ttl + "), error", e);
        } finally {
            returnJedis(jedis);
        }
    }

    @Override
	public void sadd(String key, String... members) {
        if (!isValidKey(key)) {
            return;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            jedis.sadd(key, members);
        } catch (Exception e) {
            LOGGER.error("[Jedis]sadd key(" + key + "),value(" + members + "), error", e);
        } finally {
            returnJedis(jedis);
        }
    }

    @Override
	public String spop(String key) {
        String result = "";
        if (!isValidKey(key)) {
            return result;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            result = jedis.spop(key);
        } catch (Exception e) {
            LOGGER.error("[Jedis]spop key(" + key + "), error", e);
        } finally {
            returnJedis(jedis);
        }
        return result;
    }

    @Override
	public Set<String> smembers(String key) {
        ShardedJedis jedis = null;
        Set<String> smembers = null;
        if (!isValidKey(key)) {
            return smembers;
        }
        try {
            jedis = getJedis();
            smembers = jedis.smembers(key);
        } catch (Exception e) {
            LOGGER.error("[Jedis]smembers key(" + key + "), error", e);
        } finally {
            returnJedis(jedis);
        }
        return smembers;
    }

    @Override
	public boolean expire(String key, int seconds) {
        if (!isValidKey(key)) {
            return false;
        }
        ShardedJedis jedis = null;
        try {
            jedis = getJedis();
            jedis.expire(key, seconds);
            return true;
        } catch (Exception e) {
            LOGGER.error("[Jedis]expire key(" + key + "),secs(" + seconds + "), error", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
    }

    @Override
	public boolean isExists(String key) {
        ShardedJedis jedis = null;
        boolean isExists = false;
        if (!isValidKey(key)) {
            return isExists;
        }
        try {
            jedis = jedisPool.getResource();
            isExists = jedis.exists(key);
        } catch (Exception e) {
            LOGGER.error("[Jedis]isExists key(" + key + "), error", e);
        } finally {
            returnJedis(jedis);
        }
        return isExists;
    }

    /**
     * 判断是否为有效Key,用于防止缓存穿透
     * @param key 缓存key
     * @return 是否有效
     */
    private boolean isValidKey(String key) {
        if (StringUtils.isEmpty(keyPreRule)) {
            return true;
        }
        boolean result = key.startsWith(keyPreRule);
        if (LOGGER.isErrorEnabled() && !result) {
            LOGGER.error("[Jedis]invalid key:" + key);
        }
        return result;
    }

    public ShardedJedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(ShardedJedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public Integer getSelectDB() {
        return selectDB;
    }

    public void setSelectDB(Integer selectDB) {
        this.selectDB = selectDB;
    }

    public String getKeyPreRule() {
        return keyPreRule;
    }

    public void setKeyPreRule(String keyPreRule) {
        this.keyPreRule = keyPreRule;
    }

    @Override
	public <T> void hmset(String key, Map<String, T> hash) {
        Map<String, String> hm = new HashMap<String, String>();
        for (Map.Entry<String, T> entry : hash.entrySet()) {
            hm.put(entry.getKey(), JSON.toJSONString(entry.getValue()));
        }
        getJedis().hmset(key, hm);
    }

    @Override
	public boolean hset(String key, String field, Object value,Integer seconds) {
    	ShardedJedis jedis = null;
        try {
        	jedis = getJedis();
        	jedis.hset(key, field, JSON.toJSONString(value));
        	if(seconds!=null){
        		jedis.expire(key, seconds);
        	}
        } catch (Exception e) {
            LOGGER.error(" hset exception", e);
            return false;
        } finally {
            returnJedis(jedis);
        }
        return true;
    }

    @Override
	public <T> T hget(String key, String field, Class<T> clazz) {
    	ShardedJedis jedis = null;
    	try {
    		jedis = getJedis();
    		String ret = jedis.hget(key, field);
    		return JSON.parseObject(ret, clazz);
    	} catch (Exception e) {
    		LOGGER.error(" hget exception", e);
    	} finally {
    		returnJedis(jedis);
    	}
        return null;
    }

    @Override
	public <T> List<T> hmget(String key, String[] fields, Class<T> clazz) {
    	ShardedJedis jedis = null;
        try {
        	jedis = getJedis();
        	List<String> lt = jedis.hmget(key, fields);
            List<T> retList = new ArrayList<T>();
            for (String fl : lt) {
                T t = JSON.parseObject(fl, clazz);
                if (t != null) {
                    retList.add(JSON.parseObject(fl, clazz));
                }
            }
            return retList;
        } catch (Exception e) {
    		LOGGER.error(" hmget exception", e);
    	} finally {
    		returnJedis(jedis);
    	}
        return null;        
    }

    @Override
	public <T> Map<String, T> hgetAll(String key, Class<T> clazz) {
    	ShardedJedis jedis = null;
        try {
        	jedis = getJedis();
	        Map<String, String> hm = jedis.hgetAll(key);
	        Map<String, T> retMap = new HashMap<String, T>();
	        for (Map.Entry<String, String> entry : hm.entrySet()) {
	            retMap.put(entry.getKey(), JSON.parseObject(entry.getValue(), clazz));
	        }
	        return retMap;
        } catch (Exception e) {
    		LOGGER.error(" hmget exception", e);
    	} finally {
    		returnJedis(jedis);
    	}
        return null; 
    }

    @Override
	public Long hdel(String key, String... fields) {
    	ShardedJedis jedis = null;
        try {
        	jedis = getJedis();
        	return jedis.hdel(key, fields);
        } catch (Exception e) {
    		LOGGER.error(" hmget exception", e);
    	} finally {
    		returnJedis(jedis);
    	}
        return null; 
    }
}
