package com.iwant.bytes;

import org.apache.commons.codec.DecoderException;  
import org.apache.commons.codec.binary.Hex; 

public class StringUtil {
	
	 /** 
     * 字节数组转换成16进制字符串 
     * @param bytes 字节数组 
     * @return 16进制字符串 
     */  
    public static String hexEncode(byte[] bytes) {  
        if (bytes == null || bytes.length <= 0) {  
            return null;  
        }  
        return new String(Hex.encodeHex(bytes)); //Hex.encodeHex(bytes, false)  
    }  
  
    /** 
     * 16进制字符串转换成字节数组 
     * @param hexStr 16进制字符串 
     * @return 字节数组 
     */  
    public static byte[] hexDecode(String hexStr) {  
        if (hexStr == null || "".equals(hexStr)) {  
            return null;  
        }  
        try {  
            char[] cs = hexStr.toCharArray();  
            return Hex.decodeHex(cs);  
        } catch (DecoderException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
     * 字节数组转为16进制字符串 
     * @param bytes 字节数组 
     * @return 16进制字符串 
     */  
    public static String byteArray2HexString(byte[] bytes) {  
        if (bytes == null || bytes.length <= 0) {  
            return null;  
        }  
        //先把byte[] 转换维char[]，再把char[]转换为字符串  
        char[] chars = new char[bytes.length * 2]; // 每个byte对应两个字符  
        final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
        for (int i = 0, j = 0; i < bytes.length; i++) {  
            chars[j++] = hexDigits[bytes[i] >> 4 & 0x0f]; // 先存byte的高4位  
            chars[j++] = hexDigits[bytes[i] & 0x0f]; // 再存byte的低4位  
        }  
  
        return new String(chars);  
    }  
  
    /** 
     * 16进制字符串转字节数组 
     * @param hexString 16进制字符串 
     * @return 字节数组 
     */  
    public static byte[] hexString2ByteArray(String hexString) {  
        if (hexString == null || "".equals(hexString)) {  
            return null;  
        }  
        //先把字符串转换为char[]，再转换为byte[]  
        int length = hexString.length() / 2;  
        char[] hexChars = hexString.toCharArray();  
        byte[] bytes = new byte[length];  
        String hexDigits = "0123456789abcdef";  
        for (int i = 0; i < length; i++) {  
            int pos = i * 2; // 两个字符对应一个byte  
            int h = hexDigits.indexOf(hexChars[pos]) << 4; // 注1  
            int l = hexDigits.indexOf(hexChars[pos + 1]); // 注2  
            if (h == -1 || l == -1) { // 非16进制字符  
                return null;  
            }  
            bytes[i] = (byte) (h | l);  
        }  
        return bytes;  
    }  
      
      
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
         //String str = "15811111111";  
         String str = "0x55AA";  
         String result = null;  
         byte[] bytes = null;  
         long b = System.currentTimeMillis();  
         for(int i=0; i<10000; i++){  
             //result = byteArray2HexString(str.getBytes()); //27  
             result = hexEncode(str.getBytes());    //32  
         }  
         System.out.println("耗时："+(System.currentTimeMillis()-b));  
           
         System.out.println("result："+result);  
         long b2 = System.currentTimeMillis();  
         for(int i=0; i<10000; i++){  
             //bytes = hexString2ByteArray(result); //32  
             bytes = hexDecode(result); //16  
         }  
         System.out.println("耗时："+(System.currentTimeMillis()-b2));  
         System.out.println("result："+new String(bytes));  
    }  

}