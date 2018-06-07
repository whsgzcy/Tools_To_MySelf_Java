package com.iwant.bytes;

public class Hex {

	public void testPositiveIntToHex() {
		// 如果正数小于15时，只输入一位，而不是按我们想像的两位标准十六进制输出显示的，后面解决这个问题
		System.out.println(Integer.toHexString(2));// 2
		System.out.println(Integer.toHexString(15));// f
		System.out.println(Integer.toHexString(16));// 10
		System.out.println(Integer.valueOf("F", 16));// 16
	}

	/*
	 * Integer.valueOf()实质上调用的是Integer.parseInt()来完成的，所以
	 * Integer.parseInt()与Integer.valueOf()功能是一样的，只是返回值不 一样而已
	 */
	public void testNegativeIntToHex() {
		// 负整数时，前面输入了多余的 FF ，没有去掉前面多余的 FF，按并双字节形式输出
		System.out.println(Integer.toHexString(-2).toUpperCase());// FFFFFFFE

		// 实质上0xFF会像转换成0x000000FF后再进行位运算
		System.out.println(Integer.toHexString(-2 & 0xFF).toUpperCase());// FE
		System.out.println(Integer.toHexString(-2 & 0x000000FF).toUpperCase());// FE

		// 注，FE输出时不会为-2，因为此时不会把FE看成负数，valueOf会把所有数字串看成正的
		System.out.println(Integer.valueOf("FE", 16));// 254
		// 如果要输出-2，只能按以下形式输出
		System.out.println(Integer.valueOf("-2", 16));// -2

		// 所以要把 FE 看成负的话，只能在前面加上负号，但是这里输出还不是-2，
		// 而是先计算Integer.valueOf("FE", 16)，再在结果前加上负
		System.out.println(Integer.valueOf("-FE", 16));// -254

		/*
		 * 所以如果要输入某个负数，我们只能先求出该数的绝对值的原码十六进制，再在前面加上负号， 例如求表示-128，则先对绝对值128求十六进制
		 * 80，再在前面加上负号 -80
		 */
		System.out.println(Integer.valueOf("-80", 16));// -128

		/*
		 * 为什么说valueOf把所有数字串看成正的呢？请看下面三行代码，因为最大正数为2147483647， 如果再
		 * 在7fffffff基础上加上一个一，运行肯定会出错误（这与直接输出0x80000000不一样）， 那么就可以证明
		 */
		System.out.println(Integer.valueOf("7fffffff", 16));// 2147483647
		// 此句运行时会报错，因为最大正数为7fffffff，但如 -80000000 却又可以运行，因为没超出整数范围
		// System.out.println(Integer.valueOf("80000000", 16));//不能运行，已注掉
		System.out.println(Integer.valueOf("-80000000", 16));// -2147483648

		/*
		 * 注，输出时不是负数，而是正，因为0xFE只有8位，而整数是32位，所以以int形式出现时前 面会自动补24个零，第一位是零，所以最后是正数
		 */
		System.out.println(0xFE);// 254
		System.out.println(-0xFE);// -254
		// 但0x80000000已满，无需补，第一位为一，所以最后为负数
		System.out.println(0x80000000);// -2147483648
	}

	public void testNegativeIntToBin() {
		System.out.println(Integer.toBinaryString(-2));// 11111111111111111111111111111110
		// 实质上0xFF会像转换成0x000000FF后再进行位运算
		System.out.println(Integer.toBinaryString(-2 & 0xFF));// 11111110
		System.out.println(Integer.toBinaryString(-2 & 0x000000FF));// 11111110

		// 与上面十六进制是一样的
		System.out.println(Integer.valueOf("1111111111111111111111111111111", 2));// 2147483647
		// 下面语句运行会出错，已注掉
		// System.out.println(Integer.valueOf("10000000000000000000000000000000",
		// 2));
		System.out.println(Integer.valueOf("-10000000000000000000000000000000", 2));// -2147483648
		System.out.println(Integer.valueOf("11111110", 2));// 254
		System.out.println(Integer.valueOf("-11111110", 2));// -254

		/*
		 * 注，Java中没有直接使用二进制表示一个数（目前只支持八与十六进制直接表示法），下面其实是一个 八进制的数与十进制的数
		 */
		System.out.println(010);// 8
		System.out.println(10);// 10
	}

	public void testByteToHex() {

		byte negativeByte = -2;
		byte positiveByte = 2;

		/*
		 * toHexString方法类型为int型，所以转Hex前参数会提升成整型后再进行转换，过程如下：
		 * 10000010(原码)->11111110(补码)->11111111 11111111 11111111 11111110(提升)
		 * ->FFFFFFFE(转Hex进制输出)
		 */
		System.out.println(Integer.toHexString(negativeByte).toUpperCase());// FFFFFFFE

		/*
		 * 第一步把-2转成整型： 10000010(原码)->11111110(补码)->11111111 11111111 11111111
		 * 11111110(转整型) 第二步把 0xFF 前补24个零： 00000000 00000000 00000000 11111111
		 * 第三步：把第一二步结果进行与位运算： 00000000 00000000 00000000 11111110 最后一步：转十六进制结果为
		 * FE
		 */
		System.out.println(Integer.toHexString(negativeByte & 0xFF).toUpperCase());// FE

		// 另一种转换，可以针对负数与正数的byte都可以以完整的单字节输出
		System.out.println(Integer.toHexString((negativeByte & 0x000000ff) | 0xffffff00).substring(6).toUpperCase());// FE
		System.out.println(Integer.toHexString((positiveByte & 0x000000ff) | 0xffffff00).substring(6).toUpperCase());// 02
	}

	/**
	 * 位运算与算术运行中的类型提升机制是一样的
	 */
	public void testBiteMathematical() {
		System.out.println(0x8000000000000000L);// -9223372036854775808
		System.out.println((int) 0x8000000000000000L);// 0
		System.out.println(0x8000000000000010L);// -9223372036854775792
		System.out.println(0x80000000);// -2147483648
		System.out.println(0x80000010);// -2147483632

		// 0x00000010提升成长整型，最后结果为长整型0x8000000000000010L
		System.out.println(0x00000010 | 0x8000000000000000L);// -9223372036854775792
		// 0x0010提升成整形，最后结果为整型0x80000010
		System.out.println(0x0010 | 0x80000000);// -2147483632
	}

	public static void main(String[] args) {
		
		new Hex().testByteToHex();
		new Hex().testNegativeIntToHex();


	}

}
