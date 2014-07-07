package com.ch7.f04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		ExecutorService exec = Executors.newCachedThreadPool(factory);
		
		MyTask task = new MyTask();
		//Thread thread = factory.newThread(task);
		//thread.start();
		exec.submit(task);
		exec.shutdown();
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: End of the example.\n");
	}
}
