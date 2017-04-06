package com.tj.common.zookeeper.base;

import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * zk客户端初始化类
 * 
 * @author silongz
 *
 */
public class ZkClient {

	private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);

	private final static ResourceBundle zkConfig = ResourceBundle.getBundle("zookeeper");

	private static String authType;

	private static String userName;

	private static String password;

	/**
	 * 重连间隔时间默认1秒
	 */
	private static int RETRY_INTERVAL = 1000;

	/**
	 * 默认重连3次
	 */
	private static int RETRY_TIMES = 3;

	private final static CuratorFramework client;

	private ZkClient() {

	}

	static {
		String zkAddress = zkConfig.getString("zkAddress");
		String retryInterval = zkConfig.getString("retryInterval");
		String retryTimes = zkConfig.getString("retryTimes");
		authType = zkConfig.getString("authType");
		userName = zkConfig.getString("userName");
		password = zkConfig.getString("password");
		if (StringUtils.isNumeric(retryInterval)) {
			RETRY_INTERVAL = Integer.parseInt(retryInterval);
		}
		if (StringUtils.isNumeric(retryTimes)) {
			RETRY_TIMES = Integer.parseInt(retryTimes);
		}
		// 配置了连接权限
		if (StringUtils.isNotBlank(authType) && StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
			client = CuratorFrameworkFactory.builder().aclProvider(new TjACLProvider(userName, password))
					.authorization(authType, userName.concat(":").concat(password).getBytes()).connectString(zkAddress)
					.retryPolicy(new ExponentialBackoffRetry(RETRY_INTERVAL, RETRY_TIMES)).build();
			// 没有配置节点权限的客户端
		} else {
			client = CuratorFrameworkFactory.newClient(zkAddress, new ExponentialBackoffRetry(RETRY_INTERVAL, RETRY_TIMES));
		}
		client.start();
	}

	public static CuratorFramework getClient() {
		return client;
	}

	public static void addListener(final ZKListenerCallBack callback) {
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			// 设置节点的cache
			TreeCache treeCache = new TreeCache(callback.getClient(), callback.getListenPath());
			// 设置监听器和处理过程
			treeCache.getListenable().addListener(new TreeCacheListener() {
				@Override
				public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
					ChildData data = event.getData();
					if (data != null) {
						switch (event.getType()) {
						case NODE_ADDED:
							// System.out.println("NODE_ADDED : "+
							// data.getPath() +"  数据:"+ new
							// String(data.getData()));
							callback.addNode(data);
							break;
						case NODE_REMOVED:
							// System.out.println("NODE_REMOVED : "+
							// data.getPath() +"  数据:"+ new
							// String(data.getData()));
							callback.removeNode(data);
							break;
						case NODE_UPDATED:
							// System.out.println("NODE_UPDATED : "+
							// data.getPath() +"  数据:"+ new
							// String(data.getData()));
							callback.updateNode(data);
							break;

						default:
							break;
						}
					} else {
						// System.out.println( "data is null : "+
						// event.getType());
					}
				}
			});
			// 开始监听
			treeCache.start();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("注册监听器失败：", e);
		}
	}
}
