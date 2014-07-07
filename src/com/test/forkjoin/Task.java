package com.test.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Task extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5290784361686778281L;
	
	private int number;
	private int start,end;
	
	private TaskManager manager;
	

	public Task(int number,int start,int end,TaskManager manager) {
		this.number = number;
		this.start = start;
		this.end = end;
		this.manager = manager;
	}

	@Override
	protected Integer compute() {
		if((end-start)<5){
			first();
		}else{
			second();
		}
		return 0;
	}

	private void second() {
		int mid = (end+start)/2;
		Task t1 = new Task(number, start, mid,manager);
		Task t2 = new Task(number, mid, end,manager);
		manager.addTask(t1);
		manager.addTask(t2);
		t1.fork();
		t2.fork();
	}

	private void first() {
		for (int i = start; i < end; i++) {
			if(i == number){
				System.out.printf("Task: Number %d found in position %d\n",number,i);
				manager.cancelTask(this);
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
	
	public void writeCancelMessage(){
		System.out.printf("Task: Cancelled task from %d to %d\n",start,end);
	}

}
