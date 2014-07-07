package com.ch3.f02;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrintQueue printQueue = new PrintQueue();
		Thread[] threads = new Thread[20];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Job(printQueue));
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}

}
