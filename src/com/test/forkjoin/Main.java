package com.test.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TaskManager manager = new TaskManager();
		Task task = new Task(99, 0, 100, manager);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main end!");

	}

}
