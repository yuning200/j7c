package com.ch2.f01;
/**
 * ���ǽ�ʵ��һ���������̷߳��ʹ�ͬ�����ʾ�������ǽ���һ�������ʻ��������̣߳�
 * ����һ���߳̽�Ǯת�Ƶ��ʻ�����һ���߳̽����˻��пۿ
	��û��ͬ�����������ǿ��ܵõ�����ȷ�Ľ����ͬ�����Ʊ�֤���˻�����ȷ��
	
	�˺ţ�Account,����Bank����Ǯ100�Σ�ÿ��1000�� ����˾Company����Ǯ100�Σ�ÿ��1000��
	
 * @author lvyj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account account = new Account(500);
		Company company = new Company(account);
		Bank bank = new Bank(account);
		Thread companyThread  = new Thread(company);
		Thread bankThread = new Thread(bank);
		System.out.println("degin surplus balance:"+account.getBalance());
		companyThread.start();
		bankThread.start();
		try {
			companyThread.join();
			bankThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end surplus balance:"+account.getBalance());
		

	}
}
