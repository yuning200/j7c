package com.ch6.f02;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedBlockingDeque<String> link = new LinkedBlockingDeque<>(3);
		Client client = new Client(link);
		Thread thread = new Thread(client);
		thread.start();
		for (int i = 0; i < 5; i++) {
			for (int j= 0; j < 3; j++) {
				try {
					String request = link.take();
					System.out.printf("Main: Request: %s at %s. Size: %d\n",request,new Date(),link.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.printf("Main: End of the program.\n");
	}
}
