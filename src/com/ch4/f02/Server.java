package com.ch4.f02;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	private ThreadPoolExecutor exceutor;

	public Server() {
		exceutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
	}
	
	public void executeTask(Task task){
		System.out.printf("Server: A new task has arrived\n");
		exceutor.execute(task);
		System.out.printf("Server: Pool Size: %d\n",exceutor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",exceutor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n",exceutor.getCompletedTaskCount());
	}
	
	public void endServer(){
		exceutor.shutdown();
	}

}
