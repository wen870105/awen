package com.wen.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 参考简化Fluent HC 部分代码
 * @Author: Wen
 * @CreatDate: 2015年11月11日
 * @Version:
 */
public class Request {
	private static final Logger logger = Logger.getLogger(Request.class);

	private final HttpRequestBase request;

	public Request(HttpRequestBase request) {
		this.request = request;
	}

	public Request addHeader(final String name, final String value) {
		this.request.addHeader(name, value);
		return this;
	}

	public String execute() throws IOException {
		String resultStr = null;
		HttpResponse resp = internalExecute();

		HttpEntity entity = resp.getEntity();
		int status = resp.getStatusLine().getStatusCode();
		if (status >= 200 && status < 300) {
			resultStr = entity != null ? EntityUtils.toString(entity) : null;
		} else {
			throw new IOException("不支持的响应状态: " + status);
		}
		return resultStr;
	}

	private HttpResponse internalExecute() throws ClientProtocolException, IOException {
		return Executor.CLIENT.execute(this.request);
	}

	/**
	 * 设置参数
	 * @param formParams
	 * @return
	 */
	public Request bodyForm(List<NameValuePair> formParams) {
		final List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (NameValuePair param : formParams) {
			nvps.add(param);
		}

//		RequestEntity se = new StringRequestEntity(transJson, "application/json", "UTF-8");

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, Consts.UTF_8);

		if (this.request instanceof HttpEntityEnclosingRequest) {
			((HttpEntityEnclosingRequest) this.request).setEntity(entity);
		} else {
			throw new IllegalStateException(this.request.getMethod()
					+ " request 不能设置entity.");
		}
		return this;
	}

	public static Request Get(final String uri) {
		return new Request(new HttpGet(uri));
	}

	public static Request Post(final String uri) {
		return new Request(new HttpPost(uri));
	}

	public static void main(String[] args) throws IOException {
		try {
			Request.Post("http://192.168.0.112:8089/messages")
			.bodyForm(Form.form().add("msgid", "M0101").add("target", "1").add("param", "{\"orderno\":\"1\"}").build())
			.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		String s = Request.Get("http://www.baidu.com").execute();
//		System.out.println(s);
	}
}
