/* 
 * @(#)Main.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f02;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ионГ10:07:29 $
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Phaser phaser = new Phaser(3);
		for (int i = 0; i < 3; i++) {
			Task task = new Task(i, phaser);
			Thread thread = new Thread(task);
			thread.start();
		}
		
		for (int i = 0; i < 10; i++) {

			System.out.printf("********************\n");
			System.out.printf("Main: Phaser Log\n");
			System.out.printf("Main: Phaser: Phase: %d\n",phaser.getPhase());
			System.out.printf("Main: Phaser: Registered Parties: %d\n",phaser.getRegisteredParties());
			System.out.printf("Main: Phaser: Arrived Parties: %d\n",phaser.getArrivedParties());
			System.out.printf("Main: Phaser: Unarrived Parties: %d\n",phaser.getUnarrivedParties());
			System.out.printf("********************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
