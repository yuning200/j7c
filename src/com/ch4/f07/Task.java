package com.ch4.f07;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable{
	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: Executed at: %s\n",name,new Date());		
	}

}
