package com.iwant.buff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ReadTxtAndWirteTxt {

	public static void main(String[] args) {

		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
			/* 读入TXT文件 */
			String pathname = "/Users/super_yu/Desktop/t.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			File filename = new File(pathname); // 要读取以上路径的input。txt文件
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String line = "";
			// line = br.readLine();
			StringBuffer b = new StringBuffer();
			while (line != null) {
				line = br.readLine(); // 一次读入一行数据
				System.out.println(line);
				if (line != null) {
					b.append(line);
					// line = line.substring(47, line.length());
					// out.write(line + "\r\n"); // \r\n即为换行
				}
			}
			
			String content = b.toString();
			int m = 0;
			for (int i = 0; i < content.length(); i++) {
				char cc = content.charAt(i);
				String bb = cc + "";
				if (bb.equals(",")) {
					m++;
					System.out.println("m = " + m);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// String t = "01-02 15:18:08.204 D/whsgzcy ( 1776): time = 174";
		// System.out.println(t.length());
		// System.out.println(t.substring(45,t.length()));

		// try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
		//
		// /* 写入Txt文件 */
		// File writename = new File("/Users/super_yu/Desktop/tt.txt"); //
		// 相对路径，如果没有则要建立一个新的output。txt文件
		// writename.createNewFile(); // 创建新文件
		// BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		//
		// /* 读入TXT文件 */
		// String pathname = "/Users/super_yu/Desktop/a.txt"; //
		// 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
		// File filename = new File(pathname); // 要读取以上路径的input。txt文件
		// InputStreamReader reader = new InputStreamReader(new
		// FileInputStream(filename)); // 建立一个输入流对象reader
		// BufferedReader br = new BufferedReader(reader); //
		// 建立一个对象，它把文件内容转成计算机能读懂的语言
		// String line = "";
		// // line = br.readLine();
		// while (line != null) {
		// line = br.readLine(); // 一次读入一行数据
		// System.out.println(line);
		// if (line != null) {
		// line = line.substring(47, line.length());
		// out.write(line + "\r\n"); // \r\n即为换行
		// }
		// }
		//
		// out.flush(); // 把缓存区内容压入文件
		// out.close(); // 最后记得关闭文件
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

}
