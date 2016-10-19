package com.wen.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
  
public class HttpsUtil {  
//	private static final CloseableHttpClient httpclient = HttpClients.createDefault();
	private static final HttpClient httpclient = Executor.CLIENT;

	public static String post(String url, String content) throws Exception {
		HttpPost post = new HttpPost(url);

		post.setHeader("content-type", "application/json");
		post.setHeader("accept", "application/json");

		StringEntity entity = new StringEntity(content, "utf-8");
		post.setEntity(entity);

		HttpResponse response = httpclient.execute(post);
		return read(response.getEntity().getContent());
	}

	public static String get(String url) throws Exception {
		HttpGet get = new HttpGet(url);

		get.setHeader("content-type", "application/json");
		get.setHeader("accept", "application/json");

		HttpResponse response = httpclient.execute(get);
		return read(response.getEntity().getContent());
	}

	private static String read(InputStream stream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream, "utf-8"));
		StringBuffer buf = new StringBuffer();
		String line;
		while (null != (line = br.readLine())) {
			buf.append(line).append("\n");
		}
		return buf.toString();
	}
}
