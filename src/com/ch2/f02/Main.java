package com.ch2.f02;

/**
 * 编程模拟一家电影院有两个屏幕和两个售票处。当一个售票处出售门票，它们用于两个电影院的其中一个，但不能用于两个，
	所以在每个电影院的免费席位的数量是独立的属性
	
	电影院:Cinema(可以买票，退票) 买票口：TicketOfficeFirst,TicketOfficeSercond
	
 * @author lvyj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		System.out.println("begin cinema's ticketFirst ticket count:"+cinema.getTicketCount1());
		System.out.println("begin cinema's ticketSercond ticket count:"+cinema.getTicketCount2());
		new Thread(new TicketOfficeFirst(cinema), "ticketOff01").start();
		new Thread(new TicketOfficeSercond(cinema), "ticketOff01").start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end cinema's ticketFirst ticket count:"+cinema.getTicketCount1());
		System.out.println("edn cinema's ticketSercond ticket count:"+cinema.getTicketCount2());

	}
}
