package com.ch2.f02;

public class Cinema {
	//ÂòÆ±´¦¶ÔÓ¦µÄÆ±Êı
	private long ticketCount1;
	private long ticketCount2;
	//Ëø¶ÔÏó
	private Object cinema1,cinema2;
	
	public Cinema(){
		ticketCount1 = 20;
		ticketCount2 = 20;
		cinema1 = new Object();
		cinema2 = new Object();
	}
	
	/**
	 * 1ºÅÂòÆ±
	 * @return
	 */
	public boolean sellTicket01(int count){
		synchronized(cinema1){
			if(count<=ticketCount1){
				ticketCount1 -=count;
				return true;
			}else{
				return false;
			}
		}
	}
	
	
	/**
	 * 2ºÅÂòÆ±
	 * @return
	 */
	public boolean sellTicket02(int count){
		synchronized(cinema2){
			if(count<=ticketCount2){
				ticketCount2 -=count;
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * 1ºÅÍËÆ±
	 * @param count Æ±Êı 
	 * @return
	 */
	public boolean returnTicket01(int count){
		synchronized(cinema1){
				ticketCount1 +=count;
				return true;
		}
	}
	/**
	 * 2ºÅÍËÆ±
	 * @param count Æ±Êı
	 * @return
	 */
	public boolean returnTicket02(int count){
		synchronized(cinema2){
				ticketCount2+=count;
				return true;
		}
	}

	public long getTicketCount1() {
		return ticketCount1;
	}

	public long getTicketCount2() {
		return ticketCount2;
	}
}
