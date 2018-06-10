package com.iwant.file;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	
	private static FileUtils mFile;
	
	static Thread clearFileThread = new Thread(){
		@Override
		public void run() {
			if(mFile == null) return;
			mFile.deleteAll("D:\\hello world");
		};
	};
	
	public static void main(String[] args) {
		
		mFile = new FileUtils();
		
		ScheduledThreadPoolExecutor clearThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
		clearThreadPoolExecutor.scheduleAtFixedRate(clearFileThread, 1, 5, TimeUnit.SECONDS);
		
	}

}