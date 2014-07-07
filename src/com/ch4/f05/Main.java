package com.ch4.f05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService execu = Executors.newCachedThreadPool();
		List<Task> tasks = new ArrayList<>();
		List<Future<Result>> futures = new ArrayList<>(); 
		for (int i = 0; i <3; i++) {
			Task task = new Task("Task"+i);
			tasks.add(task);
		}
		
		try {
			futures =execu.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		execu.shutdown();
		for (int i = 0; i < futures.size(); i++) {
			Future<Result> fu = futures.get(i);
			Result result = null;
			try {
				result = fu.get();
				System.out.println("result: name,"+result.getName()+"value:"+result.getValue());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 
			
		}
		
		

	}

}
