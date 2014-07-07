package com.ch6.f07;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(500);
		Company company = new Company(account);
		Bank bank = new Bank(account);
		Thread comPantThread  = new Thread(company);
		Thread bankThread = new Thread(bank);
		System.out.printf("Account : Initial Balance: %d\n",account.getBalance());
		comPantThread.start();
		bankThread.start();
		
		try {
			comPantThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %d\n",account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
