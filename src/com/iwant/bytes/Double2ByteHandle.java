package com.iwant.bytes;

public class Double2ByteHandle {
	
	public static byte[] double2Bytes(double d) {  
        long value = Double.doubleToRawLongBits(d);  
        byte[] byteRet = new byte[8];  
        for (int i = 0; i < 8; i++) {  
            byteRet[i] = (byte) ((value >> 8 * i) & 0xff);  
        }  
        return byteRet;  
    }  
	
	public static double bytes2Double(byte[] arr) {  
        long value = 0;  
        for (int i = 0; i < 8; i++) {  
            value |= ((long) (arr[i] & 0xff)) << (8 * i);  
        }  
        return Double.longBitsToDouble(value);  
    }  
	
	public static byte[] intToBytes(final int num)
	{
	    //bytes from low byte to high byte
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (0xff & num);
	    bytes[1] = (byte) ((0xff00 & num) >> 8);
	    bytes[2] = (byte) ((0xff0000 & num) >> 16);
	    bytes[3] = (byte) ((0xff000000 & num) >> 24);
	    return bytes;
	}
	
	public static int bytesToInt(byte[] bytes)
	{
	    //bytes from low byte to high byte
	    int value = 0;
	    for (int i = 0; i < bytes.length; i++)
	    {
	        //value += (int)bytes[i] << (8*i);
	        value |= (bytes[i] & 0xFF) << (8*i);
	    }
	    return value;
	}

	public static void main(String[] args) {
		
		double m = 0.23;
		
		byte[] b = double2Bytes(m);
		
		System.out.println(b[0]);
		System.out.println(b.length);
		
		double n = bytes2Double(b);
		
		System.out.println(n);
		
		byte[] num = intToBytes(111111);
		System.out.println(num[0]);
		System.out.println(num.length);
		
		int num_ = bytesToInt(num);
		System.out.println(num_);
		
		byte[] l = new byte[2];
		l[0] = 11;
		l[1] = 22;
		System.out.println(l[0]);
		System.out.println(l.length);
		
		String str = "{\"n\":\"001\",\"t\":\"poi\",\"m\":{\"s\":1,\"p\":1,\"d\":\"1\",\"e\":0.06,\"c\":\"1”}}";
		byte[] str_1 = str.getBytes();
		System.out.println(str_1[0]);
		System.out.println(str_1.length);
		System.out.println(str.length());
		
		byte[] ll = new byte[1];
		ll[0] = (byte) 0xbb;
		System.out.println(ll[0]);
		System.out.println(ll.length);
		

	}

}