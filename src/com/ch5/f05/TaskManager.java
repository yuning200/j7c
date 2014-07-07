package com.ch5.f05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;



public class TaskManager {

	private List<ForkJoinTask<Integer>> tasks;
	public TaskManager() {
		tasks = new ArrayList<>();
	}
	
	public void addTask(ForkJoinTask<Integer> task){
		tasks.add(task);
	}
	
	public void cancelTask(ForkJoinTask<Integer> task){
		
		for (ForkJoinTask<Integer> fTask:tasks) {
			if(fTask != task){
				fTask.cancel(true);
				((SearchNumberTask)fTask).writeCancelMessage();
			}
		}
		
	}

}
