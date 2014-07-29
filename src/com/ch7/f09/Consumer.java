/* 
 * @(#)Consumer.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f09;
/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ионГ10:52:03 $
 */
public class Consumer implements Runnable{
	
	private MyPriorityTransferQueue<Event> buffer;
	public Consumer(MyPriorityTransferQueue<Event> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1002; i++) {
			try {
				Event value = buffer.take();
				System.out.printf("Consumer: %s: %d\n",value.getThread(),value.getPriority());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
