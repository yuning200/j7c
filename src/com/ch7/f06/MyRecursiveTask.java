package com.ch7.f06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class MyRecursiveTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4381323458631483L;
	private int[] array;
	private int start,end;

	public MyRecursiveTask(int[] array,int start,int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int ret = 0;
		MyWorkerThread thread = (MyWorkerThread)Thread.currentThread();
		thread.addTask();
		if(end - start>100){
			int mid = (start+end)/2;
			MyRecursiveTask task1 = new MyRecursiveTask(array, start, mid);
			MyRecursiveTask task2 = new MyRecursiveTask(array, mid, end);
			invokeAll(task1, task2);
			ret = addResult(task1, task2);
		}else{
			int add = 0;
			for (int i = start; i < end; i++) {
				add+=1;
			}
			ret = add;
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	private int addResult(MyRecursiveTask task1,MyRecursiveTask task2){
		int value = 0;
		try {
			value = task1.get().intValue()+task2.get().intValue();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return value;
	}

}
