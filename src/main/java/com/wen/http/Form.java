package com.wen.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * 参考代码fluent
 * @Author: Wen
 * @CreatDate: 2015年11月18日
 * @Version:
 */
public class Form {

	private final List<NameValuePair> params;

	public static Form form() {
		return new Form();
	}

	Form() {
		super();
		this.params = new ArrayList<NameValuePair>();
	}

	public Form add(final String name, final String value) {
		this.params.add(new BasicNameValuePair(name, value));
		return this;
	}

	public List<NameValuePair> build() {
		return new ArrayList<NameValuePair>(this.params);
	}

}
