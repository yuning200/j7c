/* 
 * @(#)Producer.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f09;
/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ионГ10:49:39 $
 */
public class Producer implements Runnable {
	
	private MyPriorityTransferQueue<Event> buffer;

	public Producer(MyPriorityTransferQueue<Event> queue) {
		this.buffer = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			Event event  = new Event(Thread.currentThread().getName(), i);
			buffer.put(event);
		}
	}

}
