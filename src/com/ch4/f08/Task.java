package com.ch4.f08;

import java.util.concurrent.Callable;

public class Task implements Callable<String>{


	@Override
	public String call() throws Exception {
		while(true){
			System.out.printf("Task: Test\n");
			Thread.sleep(100);
		}
	}

}
