package com.iwant.hex;

public class HexHelper {

	/*
	 * 笔者前几日在开服过程中需要将字符串转化成为16进制的字符串,在网上找到了一些方法尝试之后,均发现存在一个问题-->字符串转为16进制后再转回来,
	 * 英文正常,中文出现乱码
	 * 
	 * 经过考虑决定通过以下方式进行解决:
	 * 
	 * 1)在将字符串转为16进制之前先进行一次转化,先将其转化成为Unicode编码(相当于把中文用英文字符代替),在转化成为16进制
	 * 
	 * 2)相反的,在十六进制转换为字符串后的得到的是Unicode编码,此时再将Unicode编码解码即可获取原始字符串
	 */

	/**
	 * 字符串转换unicode
	 * 
	 * @param string
	 * @return
	 */
	public static String string2Unicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}

	/**
	 * 字符串转化成为16进制字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String strTo16(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 16进制转换成为string类型字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "UTF-8");
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * unicode 转字符串
	 */
	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			// 转换出每一个代码点
			int data = Integer.parseInt(hex[i], 16);
			// 追加成string
			string.append((char) data);
		}
		return string.toString();
	}

	/**
	 * 字符串转换成为16进制(无需Unicode编码)
	 * 
	 * @param str
	 * @return
	 */
	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			// sb.append(' ');
		}
		return sb.toString().trim();
	}

	/**
	 * 16进制直接转换成为字符串(无需Unicode解码)
	 * 
	 * @param hexStr
	 * @return
	 */
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	public static void main(String[] args) {
		
        String json = "{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"科技园路.\",\"city\":\"江苏苏州\",\"country\":\"中国\"},\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"},{\"name\":\"SoSo\",\"url\":\"http://www.SoSo.com\"}]}";

        String json2 = "6E6968616F";
        
        String json3 = "你好,hello,我是super_yu,我的电话号码是15656098064";
        
        String json4 = "E4BDA0E5A5BD2C68656C6C6F2CE68891E698AF73757065725F79752CE68891E79A84E794B5E8AF9DE58FB7E7A081E698AF3135363536303938303634";
        
        String json5 = "6E6968616F";
		
        // 1、在将字符串转为16进制之前先进行一次转化,先将其转化成为Unicode编码(相当于把中文用英文字符代替),在转化成为16进制
        // 2、相反的,在十六进制转换为字符串后的得到的是Unicode编码,此时再将Unicode编码解码即可获取原始字符串
        
        // 转换为 unicode
		String a1 = string2Unicode(json2);
		System.out.println("a1 == " + a1.toString());
		
		// 转换为 原 string
		String a2 = unicode2String(a1);
		System.out.println("a2 == " + a2.toString());
		
		// unicode 转 16进制
		String b1 = strTo16(a1);
		System.out.println("b1 == " + b1.toString());
		
		// unicode 转 16进制
		String b2 = str2HexStr(a1);
		System.out.println("b2 == " + b2.toString());
		
		// 16进制 转 unicode
		String c1 = string2Unicode(b1);
		String c2 = string2Unicode(b2);
		
		System.out.println("c1 == " + c1.toString());
		System.out.println("c2 == " + c2.toString());
		
		String d1 = str2HexStr(json5);
		System.out.println("d1 == " + d1.toString());
		
		String d2 = hexStr2Str(json5);
		System.out.println("d1 == " + d2.toString());
	}
}