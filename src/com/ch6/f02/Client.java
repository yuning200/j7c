package com.ch6.f02;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{
	
	private LinkedBlockingDeque<String> link;
	public Client(LinkedBlockingDeque<String> link) {
		this.link = link;
	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				StringBuilder builder = new StringBuilder();
				builder.append(i).append(":").append(j);
				try {
					link.put(builder.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("Client: %s at %s.\n",builder,new Date());
			}
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Client: End.\n");
	}
}
