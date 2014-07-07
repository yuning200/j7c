package com.ch2.f04;

public class Job implements Runnable{
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.println("begin "+Thread.currentThread().getName()+" print.");
		printQueue.printf(new Object());
		System.out.println("end "+Thread.currentThread().getName()+" print.");
	}
}
