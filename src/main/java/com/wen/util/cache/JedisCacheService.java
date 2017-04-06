package com.wen.util.cache;
/**
 * 缓存
 * @author Wen
 * @CreatDate: 2016年4月21日
 */
public interface JedisCacheService {
	
	/**
     * key是否在缓存中
     * @param key
     * @return
     */
    boolean isExists(String key);

    /**
     * 设置key在seconds秒之后过期
     * @param key
     * @param seconds
     * @return
     */
    boolean expire(String key, int seconds);
    
    /**
     * 根据key 获取对象
     * @param key
     * @param clazz
     * @return
     */
    <T> T get(String key, Class<T> clazz);
    
    /**
     * 根据key 获取内容
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 根据keys删除缓存中的对象，
     * @param keys
     * @return
     */
    boolean del(String... keys);
    
    /**
     * 向缓存中设置对象
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, Object value);

    /**
     * 向缓存中设置字符数据+过期时间(s)
     * @param key
     * @param value
     * @param secs
     * @return
     */
    boolean set(String key, Object value, int secs);
    
    boolean setnx(String key,String value);
    
    boolean setnx(String key,Object value, int secs);
    
    /**
     * 返回哈希表 key 中给定域 field 的值
     * @param key
     * @param field
     * @param clazz
     * @return
     */
    <T> T hget(String key, String field, Class<T> clazz);

    /**
     * 将哈希表 key 中的域 field 的值设为 value;如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作;如果域 field 已经存在于哈希表中，旧值将被覆盖
     * 返回值 0表示更新成功，1 表示创建了一个新的key
     * @param key
     * @param field
     * @param value
     */
    boolean hset(String key, String field, Object value);

    boolean hset(String key, String field, Object value,int secs);
    
    /**
     * 删除哈希表域 field 的值
     * @param key
     * @param fields
     * @return
     */
    Long hdel(String key, String... fields);
}
