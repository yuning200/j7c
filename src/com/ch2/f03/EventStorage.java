package com.ch2.f03;

import java.util.Date;
import java.util.LinkedList;

public class EventStorage {
	private int maxSize;
	private LinkedList<Date> linkedDate;

	public EventStorage() {
		maxSize = 10;
		linkedDate = new LinkedList<Date>();
	}
	
	/**
	 *放入数据
	 */
	public synchronized void set(){
		while(linkedDate.size()>= maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		linkedDate.add(new Date());
		System.out.println("set new list has count:"+linkedDate.size());
		notify();
	}
	
	/**
	 * 取出数据
	 */
	public synchronized void get(){
		while(linkedDate.size()<=0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("get new list has count:"+linkedDate.size());
		linkedDate.poll();
		notify();
	}
}
