/* 
 * @(#)Task.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f02;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ÉÏÎç10:03:27 $
 */
public class Task implements Runnable {
	private int time;
	private Phaser phaser;

	public Task(int time,Phaser phaser) {
		this.time = time;
		this.phaser = phaser;
	}


	@Override
	public void run() {
		phaser.arrive();
		System.out.printf("%s: Entering phase 1.\n",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase 1.\n",Thread.currentThread().getName());
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("%s: Entering phase 2.\n",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase 2.\n",Thread.currentThread().getName());
		phaser.arriveAndAwaitAdvance();
		
		
		System.out.printf("%s: Entering phase 3.\n",Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase 3.\n",Thread.currentThread().getName());
		phaser.arriveAndDeregister();
		
	}

}
