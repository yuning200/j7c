package com.ch4.f09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		
		Future future = executor.submit(task);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		future.cancel(true);
		System.out.println("isDone : "+future.isDone());
		System.out.println("isCancelled : "+future.isCancelled());
		executor.shutdown();
		System.out.println("executor isTerminated:"+executor.isTerminated());
	

	}

}
