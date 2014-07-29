/* 
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 上午11:23:25 $
 */
public class ParkingCounter extends AtomicInteger {

	private static final long serialVersionUID = 6918862449444451568L;
	private ReentrantLock lock;   //没有锁发现打印的日志有点歧义，会出现进去一个出去2个的日志现象。

	private int maxNumber;
	public ParkingCounter(int initialValue) {
		set(0);
		this.maxNumber = initialValue;
		this.lock = new ReentrantLock();
	}
	
	public boolean carIn(){
		lock.lock();
		for (;;) {
			int value = get();
			if(value == maxNumber){
				System.out.printf("ParkingCounter: The parking is full.\n");
				lock.unlock();
				return false;
			}else{
				int newValue= value+1;
				boolean changed = compareAndSet(value, newValue);
				if(changed){
					System.out.printf("ParkingCounter: A car has entered.\n");
					lock.unlock();
					return true;
				}
			}
		}
	}
	
	public boolean carOut(){
		lock.lock();
		for (;;) {
			int value = get();
			if(value==0){
				System.out.printf("ParkingCounter: The parking is empty.\n");
				lock.unlock();
				return false;
			}else{
				int newValue = value-1;
				boolean changed = compareAndSet(value, newValue);
				if(changed){
					System.out.printf("ParkingCounter: A car has gone out.\n");
					lock.unlock();
					return true;
				}
			}
			
		}
		
	}

}
