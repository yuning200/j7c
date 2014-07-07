package com.ch6.f03;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {

	private PriorityBlockingQueue<Event> queue;
	private int id;
	public Task(PriorityBlockingQueue<Event> link,int id) {
		this.queue = link;
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Event e = new Event(i, id);
			queue.put(e);
		}
	}
}
