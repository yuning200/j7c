package com.ch6.f01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable{
	
	private ConcurrentLinkedDeque link;

	public PollTask(ConcurrentLinkedDeque link) {
		this.link = link;
	}

	@Override
	public void run() {
		for (int i = 0; i <5000; i++) {
			link.pollFirst();
			link.pollLast();
		}
	}
}
