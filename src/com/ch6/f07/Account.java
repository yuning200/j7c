package com.ch6.f07;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
	private AtomicLong balance;

	public Account() {
		this.balance = new AtomicLong();
	}

	public long getBalance() {
		return balance.get();
	}

	public void setBalance(long balance) {
		this.balance.set(balance);
	}

	public void addBalance(long amount){
		this.balance.getAndAdd(amount);
	}
	public void subtractBalance(long amount){
		this.balance.getAndAdd(-amount);
	}
}
