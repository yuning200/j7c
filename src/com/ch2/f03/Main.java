package com.ch2.f03;

/**
 * 经典问题是生产者与消费者问题
 * 存储类：EventStorage(maxSize 上线，集合LinkedList<Date>)  有限集合， 生产者：Producer 100 次， 消费者：Consumer 100次
 * @author lvyj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EventStorage eventStorage = new EventStorage();
		new Thread(new Producer(eventStorage)).start();
		new Thread(new Consumer(eventStorage)).start();
	}

}
