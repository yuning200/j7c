package com.ch2.f04;

/**
 * ͨ������ͬ��������ͨ��Lock�ӿڼ���ʵ����ReentrantLock���������ٽ�����
 * ʵ��һ��������ģ���ӡ���С�
 * Long duration=(long)(Math.random()*10000); �漴��
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
