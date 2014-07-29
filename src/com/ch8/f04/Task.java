/* 
 * @(#)Task.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f04;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ÉÏÎç10:36:38 $
 */
public class Task extends RecursiveAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3372299407597014987L;
	private int[] array;
	private int start,end;

	public Task(int[] array,int start,int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if(end -start >100){
			int mid = (end +start) /2;
			Task task1 = new Task(array, start, mid);
			Task task2 = new Task(array, mid, end);
			task1.fork();
			task2.fork();
			task1.join();
			task2.join();
		}else{
			for (int i = start; i < end; i++) {
				array[i]++;
				try {
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		

	}

}
