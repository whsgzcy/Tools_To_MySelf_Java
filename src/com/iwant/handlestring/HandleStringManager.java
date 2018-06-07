package com.iwant.handlestring;

import java.util.ArrayList;
import java.util.List;

import com.iwant.vjson.JsonValidator;

public class HandleStringManager {

	/**
	 * 根据执行字符 String 字符串处理
	 * 
	 * @param message
	 * @return
	 */
	public static List<String> handleMessage(String message) {
		List<String> messages = new ArrayList<String>();

		String content_ = message.replace(">", "*");
		String content_1 = content_.replace("<", "*");

		String[] content_2 = content_1.split("\\*");

		for (int i = 0; i < content_2.length; i++) {
			if (content_2[i].toString().length() > 0) {
				messages.add(content_2[i].toString());
			}
		}

		for (int i = 0; i < messages.size(); i++) {
			System.out.println(messages.get(i).toString());
		}

		return messages;
	}

	/**
	 * 首位删去 <开始>结束
	 * 
	 * @param sEventString
	 * @return
	 */
	public static String serverMessage(String sEventString) {
		// 加入开始与结束的标志
		int end = sEventString.length() - 1;
		String content = sEventString.substring(1, end);
		content = "<" + content + ">";
		System.out.println(content);
		return content;
	}

	/**
	 * 处理来自server的消息
	 * 
	 * @param message
	 * @return
	 */
	public static List<String> handleMessageFromServer(String message) {
		List<String> contents = new ArrayList<String>();
		// 去除所有空格
		message = message.replace(" ", "");
		String content_1 = message.replace(">", "*");

		content_1 = content_1.replace("<", "");

		String[] content_3 = content_1.split("\\*");

		for (int i = 0; i < content_3.length; i++) {

			System.out.println("body --> " + content_3[i].toString());

			if (content_3[i].toString().length() > 0) {

				String json = "{" + content_3[i].toString() + "}";

				System.out.println("json --> " + json);

				JsonValidator validator = new JsonValidator();
				if (validator.validate(json)) {
					contents.add(json);
				}
			}
		}

		for (int i = 0; i < contents.size(); i++) {
			System.out.println("finish --> " + contents.get(i).toString());
		}
		return contents;
	}

	public static List<String> testHandleMessaeFromClient(String message) {
		List<String> contents = new ArrayList<String>();
		// 1、去除所有空格
		message = message.replace(" ", "");

		String content_1 = message.replace(">", "*");

		String[] content_3 = content_1.split("\\*");

		for (int i = 0; i < content_3.length; i++) {
			if (content_3[i].toString().length() > 0) {
				contents.add(content_3[i].toString());
				System.out.println(content_3[i].toString());
			}
		}
		return contents;
	}

	public static void testSystemCurrentTime() {
		long time1 = System.currentTimeMillis();
		System.out.println("time1 --> " + time1);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long time2 = System.currentTimeMillis();
		System.out.println("time2 -->" + time2);

		System.out.println("time -->" + (time2 - time1));
	}

	public static void main(String[] args) {
		handleMessage("89u98dadadasdadahasdasdadas");
		serverMessage("{{asdasdasdas}}");
		serverMessage("{\"n\":\"001\",\"t\":\"poi\",\"m\":{\"x\":-5.115927445571544,\"y\":0.43298509942560753}}");
		serverMessage("\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":0}>");

		String m = "<\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":0}>";
		String mm = "<\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":0}><\"t\":\"ps\",\"m\":{\"p\":";
		handleMessageFromServer(m);
		System.out.println();
		handleMessageFromServer(mm);
		System.out.println();
		testHandleMessaeFromClient("<\"n\":\"001\",\"t\":\"aw\">");
		System.out.println();
		handleMessageFromServer("<\"n\":\"001\",\"t\":\"aw\">");

		testSystemCurrentTime();
	}
}
