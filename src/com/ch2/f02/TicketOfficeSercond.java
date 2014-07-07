package com.ch2.f02;

public class TicketOfficeSercond implements Runnable{

	private Cinema cinema;
	public TicketOfficeSercond(Cinema cinema) {
		this.cinema = cinema;
	}
	@Override
	public void run() {
		cinema.sellTicket02(10);
		cinema.sellTicket02(2);
		cinema.sellTicket02(5);
		cinema.sellTicket02(4);
		cinema.returnTicket02(1);
		cinema.returnTicket02(1);
		cinema.sellTicket02(2);
		
	}
}
