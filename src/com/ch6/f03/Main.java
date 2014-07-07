package com.ch6.f03;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			Task task =new Task(queue, i);
			threads[i] = new Thread(task);
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		for (int i = 0; i < threads.length*1000; i++) {
			Event event = queue.poll();
			if(event != null){
			System.out.printf("Thread %s: Priority %d\n",event.getThread(),event.getPriority());
			}
			
		}
		System.out.printf("Main: Queue Size: %d\n",queue.size());
		System.out.printf("Main: End of the program\n");

	}

}
