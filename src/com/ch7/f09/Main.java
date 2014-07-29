/* 
 * @(#)Main.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f09;

import java.util.concurrent.TimeUnit;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ионГ9:57:42 $
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<>();
		Producer producer = new Producer(buffer);
		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new Thread(producer);
			threadArray[i].start();
		}
		
		Consumer consumer = new Consumer(buffer);
		Thread consumerThread  = new Thread(consumer);
		consumerThread.start();
		
		System.out.printf("Main: Buffer: Consumer count: %d\n",buffer.getWaitingConsumerCount());
		
		Event event = new Event("Core Event",0);
		try {
			buffer.transfer(event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: My Event has ben transfered.\n");
		
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * Write the actual consumer count
		 */
		System.out.printf("Main: Buffer: Consumer count: %d\n",buffer.getWaitingConsumerCount());
		event = new Event("Core Event 2",0);
		try {
			buffer.transfer(event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	    System.out.printf("Main: End of the program\n");

	}

}
