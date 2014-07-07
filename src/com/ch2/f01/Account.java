package com.ch2.f01;

public class Account {
	private double balance;
	public Account(double balance){
		this.balance = balance;
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * ¥Ê«Æ
	 * @param amount
	 */
	public synchronized void addBalance(double amount){
		double tem = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tem +=amount;
		balance = tem;
	}

	/**
	 * ø€«Æ
	 * @param amount
	 */
	public synchronized void subtractBalance(double amount){
		double tem = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tem -=amount;
		balance = tem;
	}

}
