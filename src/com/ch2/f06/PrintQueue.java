package com.ch2.f06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private  Lock lockObj = new ReentrantLock();

	public PrintQueue() {
	}
	
	public void printf(Object obj){
		lockObj.lock();
		
		try {
			Long duration=(long)(Math.random()*10000);
			System.out.println("print Thread Name "+Thread.currentThread().getName()+" print. and sleep "+ duration/1000 +"s");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally{
			lockObj.unlock();
		}
		

//		lockObj.lock();
//		
//		try {
//			Long duration=(long)(Math.random()*10000);
//			System.out.println("print Thread Name "+Thread.currentThread().getName()+" print. and sleep "+ duration/1000 +"s");
//			Thread.sleep(duration);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
//		finally{
//			lockObj.unlock();
//		}
	
	}
}
