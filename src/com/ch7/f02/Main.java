package com.ch7.f02;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
		for (int i = 0; i < 4; i++) {
			MyPriorityTask task = new MyPriorityTask("Task_"+i, i);
			exec.execute(task);
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 4; i < 8; i++) {
			MyPriorityTask task = new MyPriorityTask("Task_"+i, i);
			exec.execute(task);
		}
		
		exec.shutdown();

		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: End of the program.\n");
		
		

	}

}
