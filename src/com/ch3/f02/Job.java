package com.ch3.f02;

public class Job implements Runnable{
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.println("begin "+Thread.currentThread().getName()+" print.");
		printQueue.printJob(new Object());
		System.out.println("end "+Thread.currentThread().getName()+" print.");
	}
}
