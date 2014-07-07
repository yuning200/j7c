package com.ch2.f05;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
	private double price1;
	private double price2;
	private ReadWriteLock objLock ;

	public PricesInfo(double price1,double price2) {
		this.price1 = price1;
		this.price2 = price2;
		objLock = new ReentrantReadWriteLock();
	}
	
	public double getPrice1(){
		objLock.readLock().lock();
		try {
			double value = price1;
			return value;
		}finally{
			objLock.readLock().unlock();
		} 
	}
	
	public double getPrice2(){
		objLock.readLock().lock();
		try {
			double value = price2;
			return value;
		}finally{
			objLock.readLock().unlock();
		} 
	}
	
	public void setPrice(double price1,double price2){
		objLock.writeLock().lock();
		try {
			this.price1 = price1;
			this.price2 = price2;
		} finally{
			objLock.writeLock().unlock();
		}
	}

}
