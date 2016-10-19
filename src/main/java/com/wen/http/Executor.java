package com.wen.http;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLInitializationException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/**
 * 参考Fluent HC 部分代码
 * @Author: Wen
 * @CreatDate: 2015年11月11日
 * @Version:
 */
public class Executor {
	final static PoolingHttpClientConnectionManager CONNMGR;
	final static HttpClient CLIENT;

	static {
		LayeredConnectionSocketFactory ssl = null;
		try {
			ssl = SSLConnectionSocketFactory.getSystemSocketFactory();
		} catch (final SSLInitializationException ex) {
			final SSLContext sslcontext;
			try {
				sslcontext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
				sslcontext.init(null, null, null);
				ssl = new SSLConnectionSocketFactory(sslcontext);
			} catch (final SecurityException ignore) {
			} catch (final KeyManagementException ignore) {
			} catch (final NoSuchAlgorithmException ignore) {
			}
		}

		final Registry<ConnectionSocketFactory> sfr = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", ssl != null ? ssl : SSLConnectionSocketFactory.getSocketFactory())
				.build();

		CONNMGR = new PoolingHttpClientConnectionManager(sfr);
		CONNMGR.setDefaultMaxPerRoute(100);
		CONNMGR.setMaxTotal(200);
		CONNMGR.setValidateAfterInactivity(1000);
		CLIENT = HttpClientBuilder.create()
				.setConnectionManager(CONNMGR)
				.build();
	}
}
