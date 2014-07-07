package com.ch4.f03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultFuture =new ArrayList<Future<Integer>>();
		Random random = new Random(); 
		for (int i = 0; i < 10; i++) {
			Integer number = random.nextInt(10);
			FactorialCalculator fc1 = new FactorialCalculator(number);
			Future<Integer>  future = executor.submit(fc1);
			resultFuture.add(future);
		}
		
		
		// Wait for the finalization of the ten tasks
		do {
			System.out.printf("Main: Number of Completed Tasks: %d\n",executor.getCompletedTaskCount());
			for (int i=0; i<resultFuture.size(); i++) {
				Future<Integer> result=resultFuture.get(i);
				System.out.printf("Main: Task %d: %s\n",i,result.isDone());
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (executor.getCompletedTaskCount()<resultFuture.size());
		
		// Write the results
		System.out.printf("Main: Results\n");
		
		for (int i = 0; i < resultFuture.size(); i++) {
			Future<Integer> future = resultFuture.get(i);
			Integer number=null;
			try {
				number = future.get();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("Core: Task %d: %d\n",i,number);
		}
		executor.shutdown();
	}
}
