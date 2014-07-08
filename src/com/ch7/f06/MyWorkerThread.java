package com.ch7.f06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThread extends ForkJoinWorkerThread {

	private static ThreadLocal<Integer> taskCounter = new ThreadLocal<>();
	public MyWorkerThread(ForkJoinPool pool) {
		super(pool);
	}
	@Override
	protected void onStart() {
		super.onStart();
		System.out.printf("MyWorkerThread %d: Initializing task counter.\n",getId());
		taskCounter.set(0);
	}
	@Override
	protected void onTermination(Throwable exception) {
		System.out.printf("MyWorkerThread %d: %d\n",getId(),taskCounter.get());
		super.onTermination(exception);
	}
	
	public void addTask(){
		int ret = taskCounter.get().intValue();
		ret++;
		taskCounter.set(ret);
	}
	
	

}
