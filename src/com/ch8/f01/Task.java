/* 
 * @(#)Task.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f01;

import java.util.concurrent.locks.Lock;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ионГ11:55:23 $
 */
public class Task implements Runnable {
	
	private Lock  lock;
	public  Task(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			lock.lock();
			System.out.printf("%s: Get the Lock.\n",Thread.currentThread().getName());
			try {
				Thread.sleep(500);
				System.out.printf("%s: Free the Lock.\n",Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
			lock.unlock();
			}
		}
	}
}
