package com.ch2.f03;

/**
 * ����������������������������
 * �洢�ࣺEventStorage(maxSize ���ߣ�����LinkedList<Date>)  ���޼��ϣ� �����ߣ�Producer 100 �Σ� �����ߣ�Consumer 100��
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
