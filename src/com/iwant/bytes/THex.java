package com.iwant.bytes;

public class THex {
	
	public static void main(String[] args) {
		
		int a = 0x2f;//小写十六进制（等价于0x002f）  
	    System.out.println(Integer.toBinaryString(a));
	      
	    int b = 0x2F;//大写十六进制  
	    System.out.println(Integer.toBinaryString(b));
	      
	    int c = 10;//标准十进制  
	    System.out.println(Integer.toBinaryString(c));
	      
	    int d = 010;//以零开头，表示八进制  
	    System.out.println(Integer.toBinaryString(d));
	      
	    char e = 0xff;//char为2个字节，16位  
	    byte f = 0xf;//byte为8位  
	    short g = 0xff;//short为2个字节，16位  
	    System.out.println(Integer.toBinaryString(e));
	    System.out.println(Integer.toBinaryString(f)); 
	    System.out.println(Integer.toBinaryString(g));
	    
	    byte[] arr = new byte[10];
	    arr[0] = 0x3C;
	    arr[1] = 0x3E;
	    arr[2] = (byte) 0xe6;
	    System.out.println(arr[0]);
	    System.out.println(arr[1]);
	    System.out.println(arr[2]);
	    
	    String code = "0234";
	    int code1 = Integer.parseInt(code.charAt(0) + "");
	    int code2 = Integer.parseInt(code.charAt(1) + "");
	    int code3 = Integer.parseInt(code.charAt(2) + "");
	    int code4 = Integer.parseInt(code.charAt(3) + "");
	    System.out.println("code1 = " + code1);
	    System.out.println("code2 = " + code2);
	    System.out.println("code3 = " + code3);
	    System.out.println("code4 = " + code4);
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

}