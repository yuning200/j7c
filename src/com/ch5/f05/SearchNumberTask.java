package com.ch5.f05;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;


public class SearchNumberTask extends RecursiveTask<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2229901922433724139L;
	private static int NOT_FOUND = -1;
	private int[] array;
	private TaskManager manager;
	private int start,end;
	private int number;

	public SearchNumberTask(int[] array,int start,int end,int number,TaskManager manager) {
		this.array =array;
		this.start = start;
		this.end = end;
		this.number = number;
		this.manager = manager;
	}

	@Override
	protected Integer compute() {
		System.out.println("Task: "+start+":"+end);
		int ret = 0;
		if((end-start)<10){
			ret = lookForNumber();
		}else{
			ret =launchTasks(); 
		}
		return ret;
	}

	private int lookForNumber() {
		for (int i = start; i < end; i++) {
			if(array[i] == number){
				System.out.printf("Task: Number %d found in position %d\n",number,i);
				manager.cancelTask(this);
				return i;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return NOT_FOUND;
	}

	private int launchTasks() {
		int mid = (start+end)/2;
		SearchNumberTask task1 = new SearchNumberTask(array, start, mid, number, manager);
		SearchNumberTask task2 = new SearchNumberTask(array, mid, end, number, manager);
		manager.addTask(task1);
		manager.addTask(task2);
		task1.fork();
		task2.fork();
		int returnValue;
		returnValue = task1.join();
		if(returnValue != -1){
			return returnValue;
		}
		
		returnValue = task2.join();
		return returnValue;
	}
	
	public void writeCancelMessage(){
		System.out.printf("Task: Cancelled task from %d to %d\n",start,end);
	}
}
