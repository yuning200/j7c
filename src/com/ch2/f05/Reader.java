package com.ch2.f05;

public class Reader implements Runnable{
	private PricesInfo pricesInfo;

	public Reader(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("price1:"+Thread.currentThread().getName()+","+pricesInfo.getPrice1());
			System.out.println("price2:"+Thread.currentThread().getName()+","+pricesInfo.getPrice2());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
