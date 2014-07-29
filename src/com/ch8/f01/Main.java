/* 
 * @(#)Main.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f01;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ÏÂÎç5:36:57 $
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			Task task = new Task(lock);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		
		for (int i=0; i<15; i++) {
			/*
			 * Write info about the lock
			 */
			System.out.printf("Main: Logging the Lock\n");
			System.out.printf("************************\n");
			System.out.printf("Lock: Owner : %s\n",lock.getOwnerName());
			System.out.printf("Lock: Queued Threads: %s\n",lock.hasQueuedThreads());
			if (lock.hasQueuedThreads()){
				System.out.printf("Lock: Queue Length: %d\n",lock.getQueueLength());
				System.out.printf("Lock: Queued Threads: ");
				Collection<Thread> lockedThreads=lock.getThreads();
				for (Thread lockedThread : lockedThreads) {
				System.out.printf("%s ",lockedThread.getName());
				}
				System.out.printf("\n");
			}
			System.out.printf("Lock: Fairness: %s\n",lock.isFair());
			System.out.printf("Lock: Locked: %s\n",lock.isLocked());
			System.out.printf("************************\n");
			/*
			 * Sleep the thread for one second
			 */
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
