package com.ch7.f03;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory{
	private String prefix;
	private int count;

	public MyThreadFactory(String prefix) {
		this.prefix = prefix;
		count=1;
	}

	@Override
	public Thread newThread(Runnable r) {
		MyThread thread = new MyThread(r, prefix+"-"+count);
		count++;
		return thread;
	}

}
