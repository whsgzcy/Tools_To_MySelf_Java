package com.iwant.bytes;

public class ByteHandleManager {

	public static void main(String[] args) {

		// byte[] message = new byte[8];
		// message[0] = (byte) 1111;
		//
		// System.out.println(message[0]);
		//
		// Integer.parseInt("1111",16);
		//
		// System.out.println(Integer.parseInt(message[0]+"",16));

		String s;
		int a;
		a = Integer.parseInt("AA", 16);
		System.out.println(a);

		s = Integer.toHexString(a);
		System.out.println(s);

		byte[] q = new byte[10];
		q[0] = (byte) 0xAA;

		System.out.println(q[0]);

		byte g = generateByte("AA");
		System.out.println(g);

		HexToByte("0x11");

		char num = 0x55AA;

		q[0] = (byte) num;

		System.out.println(q[0]);

		int aa = 0x55aa;// 小写十六进制（等价于0x002f）
		System.out.println(Integer.toBinaryString(aa));

		int bb = 0x55AA;// 大写十六进制
		System.out.println(Integer.toBinaryString(bb));
		
	}

	// 16进制字符串转换为byte[]
	public static byte[] HexToByte(String hexString) {
		int len = hexString.length();
		byte[] b = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
			b[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
					+ Character.digit(hexString.charAt(i + 1), 16));
		}
		System.out.println(b[0]);
		return b;
	}

	public static byte generateByte(String s) {

		byte tmp = 0;
		char[] arr = s.toCharArray();
		if (arr.length > 2) {
			return tmp;
		}
		int t0 = Integer.parseInt(Character.toString(arr[0]), 16);
		int t1 = Integer.parseInt(Character.toString(arr[1]), 16);
		byte tmp0 = (byte) t0;
		byte tmp1 = (byte) t1;
		tmp = (byte) (tmp0 << 4);
		tmp = (byte) (tmp | tmp1);
		return tmp;
	}
}