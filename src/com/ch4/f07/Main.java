package com.ch4.f07;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Task task = new Task("Task");	
		ScheduledFuture<?> future = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		for(int x = 0 ;x<10;x++){
			System.out.printf("Main: Delay: %d\n",future.getDelay(TimeUnit.MILLISECONDS));
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		System.out.printf("Main: No more tasks at: %s\n",new Date());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Finished at: %s\n",new Date());
		
	}

}
