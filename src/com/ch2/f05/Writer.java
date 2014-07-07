package com.ch2.f05;

public class Writer implements Runnable {
	private PricesInfo pricesInfo;

	public Writer(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("Writer: Attempt to modify the prices.\n");
			pricesInfo.setPrice(Math.random()*10, Math.random()*8);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("Writer: Prices have been modified.\n");
		}
	}
}
