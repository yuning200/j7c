package com.ch7.f05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
		Task task = new Task();
		System.out.printf("Main: %s\n",new Date());
		executor.schedule(task, 1, TimeUnit.SECONDS);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task = new Task();
		System.out.printf("Main: %s\n",new Date());
		executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: End of the program.\n");
		
	}

}
