package com.ch6.f01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> link = new ConcurrentLinkedDeque<>();
		
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			AddTask task = new AddTask(link);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the List: %d\n",link.size());
		for (int i = 0; i < threads.length; i++) {
			PollTask task = new PollTask(link);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d PollTask threads have been launched\n",threads.length);
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the List: %d\n",link.size());
	}
}
