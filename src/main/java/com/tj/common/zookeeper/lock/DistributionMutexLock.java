package com.tj.common.zookeeper.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import com.tj.common.zookeeper.base.ZkClient;

/**
 * 分布式排它锁
 * @author silongz
 *
 */
public class DistributionMutexLock<T> {

	private final static String SLASH = "/" ;
	
	private static Map<String,InterProcessMutex> map = new ConcurrentHashMap<String,InterProcessMutex>() ;
	
	private String systemCode ;
	
	private String lockName ;
	
	public DistributionMutexLock(String systemCode , String lockName){
		if(StringUtils.isBlank(systemCode) || StringUtils.isBlank(lockName)){
			throw new IllegalArgumentException("systemCode和lockName都不能为空") ;
		}
		this.systemCode = systemCode ;
		this.lockName = lockName ;
	}
	
	public T lock(LockCallBack<T> callBack) throws Exception {
		InterProcessMutex lock = getLock() ;
		try {
			lock.acquire();
			return callBack.call() ;
		} catch (Exception e) {
			throw new RuntimeException("获取系统【"+systemCode+"】的分布式锁【" +lockName+"】失败") ;
		} finally {
			lock.release();
		}
	}
	
	/**
	 * 构建排它锁实例
	 * @param systemCode
	 * @param lockName
	 * @return
	 */
	private InterProcessMutex getLock(){
		String key = SLASH.concat(systemCode).concat(SLASH).concat(lockName) ;
		if(map.containsKey(key)){
			return map.get(key) ;
		}else{
			InterProcessMutex lock = new InterProcessMutex(ZkClient.getClient(), key);
			map.put(key, lock) ;
			return lock ;
		}
	}
	
	
}
