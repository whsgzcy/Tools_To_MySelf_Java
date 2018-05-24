package com.iwant.bytes;

public class SocketMessageHandler {
	
	public static void main(String[] args) {
				
		byte[] b = new byte[10];
		
		double w = 0.231231;
		
		b[0] = (byte) 0xBB;
		b[1] = 0x11;
		b[2] = 0x22;
		
		System.out.println(b[0]);
		
		System.out.println(Integer.toHexString(-69));
		
	}
}