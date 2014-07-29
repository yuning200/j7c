/* 
 * @(#)Sensor1.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f10;
/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ионГ11:30:24 $
 */
public class Sensor2 implements Runnable {
	private ParkingCounter counter;

	public Sensor2(ParkingCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
	
	}

}
