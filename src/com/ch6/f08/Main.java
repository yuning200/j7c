package com.ch6.f08;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int THREAD_COUNT = 100;
		AtomicIntegerArray array = new AtomicIntegerArray(1000);
		Incrementer inc = new Incrementer(array);
		Decrementer dec = new Decrementer(array);
		
		Thread[] incThread = new Thread[THREAD_COUNT];
		Thread[] decThread = new Thread[THREAD_COUNT];
		for (int i = 0; i <THREAD_COUNT; i++) {
			incThread[i] = new Thread(inc);
			decThread[i] = new Thread(dec);
			incThread[i].start();
			decThread[i].start();
		}
		
		
		
		try {
			for (int i = 0; i <THREAD_COUNT; i++) {
				incThread[i].join();
				decThread[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < array.length(); i++) {
			if(array.get(i) != 0){
				System.out.println("array["+i+"] : "+array.get(i));
			}
		}
		System.out.println("Main: End of the example");
	}
}
