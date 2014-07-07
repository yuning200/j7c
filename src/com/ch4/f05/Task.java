package com.ch4.f05;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
	
	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public Result call() throws Exception {
		System.out.printf("%s: Staring\n",this.name);
		
		try {
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: Waiting %d seconds for results.\n",this.name,duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int value= 0;
		for(int x=0;x<5;x++){
			value +=(int)(Math.random()*10);
		}
		
		Result result = new Result();
		result.setName(name);
		result.setValue(value);
		System.out.printf("%s: Ends\n",this.name);
		return result;
	}
}
