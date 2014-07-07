package com.ch3.f02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private Semaphore semaphore;
	private boolean[] freePrinters;
	private Lock lockPrinters;

	public PrintQueue() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < freePrinters.length; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object obj){
		
		try {
			semaphore.acquire();
			int assignedPrinter = getPrint();
			long d = (long)(Math.random()*10);
			System.out.println(assignedPrinter+" print ..."+Thread.currentThread().getName()+" sleep "+d);
			Thread.sleep(d);
			freePrinters[assignedPrinter] = true;
		} catch (Exception e) {

		}finally{
			semaphore.release();
		}
	}

	private int getPrint() {
		int number = -1;
		try {
			lockPrinters.lock();
			
			for (int i = 0; i < freePrinters.length; i++) {
				if(freePrinters[i]){
					number = i;
					freePrinters[i] = false;
					break;
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lockPrinters.unlock();
		}
		return number;
	}
}
