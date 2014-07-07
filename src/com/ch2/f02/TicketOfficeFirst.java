package com.ch2.f02;

public class TicketOfficeFirst implements Runnable{
	private Cinema cinema;

	public TicketOfficeFirst(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void run() {
		cinema.sellTicket01(3);
		cinema.sellTicket01(2);
		cinema.sellTicket01(1);
		cinema.sellTicket01(4);
		cinema.sellTicket01(11);
		cinema.returnTicket01(5);
		cinema.sellTicket01(11);
	}
}
