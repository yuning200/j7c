package com.ch2.f01;
/**
 * 我们将实现一个有两个线程访问共同对象的示例。我们将有一个银行帐户和两个线程：
 * 其中一个线程将钱转移到帐户而另一个线程将从账户中扣款。
	在没有同步方法，我们可能得到不正确的结果。同步机制保证了账户的正确。
	
	账号：Account,银行Bank（扣钱100次，每次1000） ，公司Company（存钱100次，每次1000）
	
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
