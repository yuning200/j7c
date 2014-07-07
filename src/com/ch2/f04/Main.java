package com.ch2.f04;

/**
 * 通过锁来同步代码块和通过Lock接口及其实现者ReentrantLock类来创建临界区，
 * 实现一个程序来模拟打印队列。
 * Long duration=(long)(Math.random()*10000); 随即数
 * @author lvyj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread[] thread = new Thread[10];
		for(int i=0;i<10;i++){
			thread[i] = new Thread(new Job(printQueue));
		}
		
		for(int i=0;i<10;i++){
			thread[i].start();
		}
	}
}
