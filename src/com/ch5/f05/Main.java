package com.ch5.f05;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayGenerator generator = new ArrayGenerator();
		int[] array = generator.generateArray(1000);
		TaskManager manager  = new TaskManager();
		SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: The program has finished\n");
	}

}
