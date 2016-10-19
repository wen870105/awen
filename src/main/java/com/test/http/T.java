package com.test.http;

import java.io.IOException;

import com.wen.http.Form;
import com.wen.http.Request;

public class T {
	public static void main(String[] args) throws IOException {

		String s = "http://127.0.0.1:8080/users/createTaskNo";
		s = "http://127.0.0.1:8080/tj-task-order-service/orderInfo/update";
		try {
			String res =
					Request.Post(s).bodyForm(Form.form().add("name", "M0101").add("target", "1")
							.add("param", "{\"orderno\":\"1\"}")
							.build())
							.execute();
			System.out.println("response: " + res);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//		String s = Request.Get("http://www.baidu.com").execute();
		//		System.out.println(s);
	}
}
