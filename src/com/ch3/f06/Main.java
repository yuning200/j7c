package com.ch3.f06;

import java.util.concurrent.Phaser;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		FileSearch system  = new FileSearch("C:\\Windows", "log", phaser);
		FileSearch apps  = new FileSearch("C:\\Program Files", "log", phaser);
		FileSearch documents   = new FileSearch("C:\\Documents And Settings", "log", phaser);
		Thread systemThread  = new Thread(system,"system");
		systemThread.start();
		Thread appsThread  = new Thread(apps,"apps");
		appsThread.start();
		Thread documentsThread  = new Thread(documents,"documents");
		documentsThread.start();
		
		try {
			systemThread.join();
			appsThread.join();
			documentsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 // 31. 使用isFinalized()方法把Phaser对象的结束标志值写入操控台。
		 System.out.println("Terminated: " + phaser.isTerminated());
	}
}
