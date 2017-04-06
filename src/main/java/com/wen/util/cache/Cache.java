package com.wen.util.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Cache {

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
     * 返回集合 key 中的所有成员
     * @param key
     * @return
     */
    Set<String> smembers(String key);

    /**
     * 移除并返回集合中的一个随机元素
     * @param key
     * @return
     */
    String spop(String key);

    /**
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
     * 假如 key 不存在，则创建一个只包含 member 元素作成员的集合。
     * 当 key 不是集合类型时，返回一个错误。
     * @param key
     * @param members
     */
    void sadd(String key, String... members);

    /**
     * 将 key 所储存的值加上增量 value,ttl秒之后过期
     * @param key
     * @param value
     * @param ttl
     */
    void incrBy(String key, long value, int ttl);

   /**
    * 将 key 中储存的数字值增一,ttl秒之后过期
    * @param key
    * @param ttl
    * @return
    */
    Long incr(String key, int ttl);

    /**
     *  将 key 中储存的数字值增一
     * @param key
     * @return
     */
    Long incr(String key);

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。 当 key 存在但不是字符串类型时，返回一个错误
     * @param key
     * @param value
     * @param clazz
     * @return
     */
    <T> T getSet(String key, Object value, Class<T> clazz);

    /**
     * 根据key 获取对象
     * @param key
     * @param clazz
     * @return
     */
    <T> T get(String key, Class<T> clazz);

    /**
     * 获取字符串类型的值
     * @param key
     * @return
     */
    String getString(String key);

    /**
     * 获取长整类型的值
     * @param key
     * @return
     */
    Long getLong(String key);

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
     * 将 key 的值设为 value ，当且仅当 key 不存在;若给定的 key 已经存在，则 SETNX 不做任何动作
     * @param key
     * @param value
     * @return
     */
    boolean setnx(String key, Object value);

    /**
     * 向缓存中设置对象+过期时间(s)
     * @param key
     * @param value
     * @param secs
     * @return
     */
    boolean set(String key, Object value, int secs);

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
    boolean set(String key, String value, int secs);

    /**
     * 向缓存中设置字符数据
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    /**
     * 返回哈希表 key 中，所有的域和值
     * @param key
     * @param clazz
     * @return
     */
    <T> Map<String, T> hgetAll(String key, Class<T> clazz);

    /**
     * 返回哈希表 key 中，一个或多个给定域的值
     * @param key
     * @param fields
     * @param clazz
     * @return
     */
    <T> List<T> hmget(String key, String[] fields, Class<T> clazz);

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
     * @param seconds
     */
    boolean hset(String key, String field, Object value,Integer seconds);

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中;如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作
     * @param key
     * @param hash
     */
    <T> void hmset(String key, Map<String, T> hash);
    
    /**
     * 删除哈希表域 field 的值
     * @param key
     * @param fields
     * @return
     */
    public Long hdel(String key, String... fields);


}
