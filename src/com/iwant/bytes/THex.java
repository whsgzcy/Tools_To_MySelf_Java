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
	    arr[0] = 0x10;
	    System.out.println(arr[0]);
	}
}