package com.ch6.f06;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
			TaskLocalRandom task = new TaskLocalRandom();
			new Thread(task,"Task_"+i).start();
		}
	}
}
