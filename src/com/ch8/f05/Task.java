/* 
 * @(#)Task.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f05;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ÏÂÎç4:07:58 $
 */
public class Task implements Runnable {
	@Override
	public void run() {
		Logger logger = MyLogger.getLogger(this.getClass().getName());
		logger.entering(Thread.currentThread().getName(), "run()");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.exiting(Thread.currentThread().getName(), "run()",Thread.currentThread());
	}
}
