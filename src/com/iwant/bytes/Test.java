package com.iwant.bytes;

public class Test {
	
	public static void main(String[] args) {
		
		// 组织好 byte业务逻辑
		byte[] b = new byte[30];
		b[0] = 60;
		b[29] = 62;

		b[1] = 11;
		b[2] = 11;
		b[3] = 11;

		byte[] x = double2Bytes(1.323);
		byte[] y = double2Bytes(11.545);
		byte[] p = double2Bytes(0.68);
		
		System.arraycopy(x, 0, b, 4, 8);
		System.arraycopy(y, 0, b, 12, 8);
		System.arraycopy(p, 0, b, 20, 8);
		
		double xx = bytes2Double(x);
		double yy = bytes2Double(y);
		double pp = bytes2Double(p);
		
		System.out.println("xx = " + xx);
		System.out.println("yy = " + yy);
		System.out.println("pp = " + pp);
		
		// 取出 double 的 byte[]
			
		for(int i = 0; i < b.length; i++){
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		// 写成 16进制字符串
		String hexStr = bytesToHexFun1(b);
		System.out.println(hexStr);
		System.out.println(hexStr.length());
		// 16进制重新转换为 byte
		byte[] strs = toBytes(hexStr);
		for(int i = 0; i < strs.length; i++){
			System.out.print(strs[i] + " ");
		}
	}
	
	public static byte[] double2Bytes(double d) {
		long value = Double.doubleToRawLongBits(d);
		byte[] byteRet = new byte[8];
		for (int i = 0; i < 8; i++) {
			byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
		}
		return byteRet;
	}
	
	/**
     * 方法一：
     * byte[] to hex string
     * 
     * @param bytes
     * @return
     */
	private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', 
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String bytesToHexFun1(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制位标识
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for(byte b : bytes) { // 使用除与取余进行转换
            if(b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }
        return new String(buf);
    }
    
    /**
     * 方法二：
     * byte[] to hex string
     * 
     * @param bytes
     * @return
     */
    public static String bytesToHexFun2(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for(byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }
    
    /**
     * 方法三：
     * byte[] to hex string
     * 
     * @param bytes
     * @return
     */
    public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }

    /**
     * 将16进制字符串转换为byte[]
     * 
     * @param str
     * @return
     */
    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public static double bytes2Double(byte[] arr) {  
        long value = 0;  
        for (int i = 0; i < 8; i++) {  
            value |= ((long) (arr[i] & 0xff)) << (8 * i);  
        }  
        return Double.longBitsToDouble(value);  
    }  
}