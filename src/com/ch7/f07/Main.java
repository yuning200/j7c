package com.ch7.f07;

import java.util.concurrent.ForkJoinPool;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] array  = new int[10000];
		Task task = new Task("Task", array, 0, array.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		pool.shutdown();
		System.out.printf("Main: End of the program.\n");
	}

}
