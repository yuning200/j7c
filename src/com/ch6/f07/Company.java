package com.ch6.f07;

public class Company implements Runnable{
	private Account account;
	public Company(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i <10; i++) {
			account.addBalance(1000);
		}
	}
}
