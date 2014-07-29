/* 
 * @(#)Task.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f03;

import java.util.concurrent.TimeUnit;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ÉÏÎç10:16:39 $
 */
public class Task implements Runnable {
	private long milliseconds;

	public Task(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	@Override
	public void run() {
		System.out.printf("%s: Begin\n",Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: End\n",Thread.currentThread().getName());
	}

}
