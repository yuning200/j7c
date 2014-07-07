package com.ch6.f01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable {
	private ConcurrentLinkedDeque<String> link ;

	public AddTask(ConcurrentLinkedDeque<String> link) {
		this.link = link;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			String name = Thread.currentThread().getName();
			link.add(name+": Element "+i);
		}
	}
}
