package com.ch2.f05;

/**
 * ʹ��ReadWriteLock�ӿ�ʵ��һ������ʹ���������Ʒ���һ���洢������Ʒ�۸�Ķ���
	PricesInfo�࣬�������洢������Ʒ�۸����Ϣ��ʵ�����ü۸�ͻ�ȡ�۸�
	Reader�� �����۸��ӡ������̨����ȡ10�Ρ�
	Writer�࣬�޸ļ۸������۸�ͬʱ�޸ġ��޸�3�Σ�����Ϊ�漴��(Math.random()*10, Math.random()*8)
	Main ��5���̻߳�ȡ�۸�1���߳��޸ļ۸�
 * @author lvyj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo(1,2);
		Reader[] readers = new Reader[5];
		Thread[] thArray = new Thread[5];
		for (int i = 0; i <5; i++) {
			readers[i] = new Reader(pricesInfo);
			thArray[i] = new Thread(readers[i]);
		}
		Writer writer = new Writer(pricesInfo);
		
		for (int i = 0; i <5; i++) {
			thArray[i].start();
		}
		new Thread(writer).start();
	}
}
