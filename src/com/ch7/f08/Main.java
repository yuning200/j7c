package com.ch7.f08;

import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		
		for (int i = 0; i <10; i++) {
			Task task = new Task(lock, "TASK_"+i);
			Thread thread = new Thread(task);
			thread.start();
		}
		
		boolean value ;
		do {
			try {
				value = lock.tryLock(1, TimeUnit.SECONDS);
				if(!value){
					System.out.printf("Main: Trying to get the Lock\n");
				}
			} catch (InterruptedException e) {
				value = false;
				e.printStackTrace();
			}
		} while (!value);
		
		System.out.printf("Main: Got the lock\n");
		lock.unlock();
		System.out.printf("Main: End of the program\n");
	}
}
