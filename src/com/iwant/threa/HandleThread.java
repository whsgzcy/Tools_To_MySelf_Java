package com.iwant.threa;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandleThread {
	
//	static Thread t1 = new Thread(){
//		public void run() {
//			System.out.println("thread ---> " + "t1");
//		};
//	};
//	
//	static Thread t2 = new Thread(){
//		public void run() {
//			System.out.println("thread ---> " + "t2");
//		};
//	};
//	
//	static Thread t3 = new Thread(){
//		public void run() {
//			System.out.println("thread ---> " + "t3");
//		};
//	};
	
	static Thread t4 = new Thread(){
		public void run() {
			
			while(true){
				
				try {
					System.out.println("1111");
					Thread.sleep(2000);
					
					System.out.println("2222");
					Thread.sleep(2000);
					
					System.out.println("3333");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//				try {
//					System.out.println("2222");
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				try {
//					System.out.println("3333");
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				// one
				
				// two
				
				//three
				
			}
			
		};
	};
	
	public static void main(String[] args) {
//		ScheduledThreadPoolExecutor test = new ScheduledThreadPoolExecutor(3);
//		test.scheduleAtFixedRate(t1, 1, 5, TimeUnit.SECONDS);
//		test.scheduleAtFixedRate(t2, 1, 5, TimeUnit.SECONDS);
//		test.scheduleAtFixedRate(t3, 1, 5, TimeUnit.SECONDS);
		
		t4.start();
	}
}