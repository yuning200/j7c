/* 
 * @(#)Main.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f10;
/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ÉÏÎç11:32:28 $
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ParkingCounter counter = new ParkingCounter(5);
		Sensor1 sensor1 = new Sensor1(counter);
		Sensor2 sensor2 = new Sensor2(counter);
		Thread thread1 = new Thread(sensor1);
		Thread thread2 = new Thread(sensor2);
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.printf("Main: Number of cars: %d\n",counter.get());
		
		/*
		 * Writ a message indicating the end of the program
		 */
		System.out.printf("Main: End of the program.\n");
	}

}
