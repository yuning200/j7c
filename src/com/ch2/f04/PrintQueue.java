package com.ch2.f04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Lock lockObj = new ReentrantLock();

	public PrintQueue() {
	}
	
	public void printf(Object obj){
		lockObj.lock();
		
		try {
			Long duration=(long)(Math.random()*10000);
			System.out.println("print Thread Name "+Thread.currentThread().getName()+" print. and sleep "+ duration/100 +"s");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		finally{
			lockObj.unlock();
		}
	}
}
