package com.ch2.f02;

public class Cinema {
	//��Ʊ����Ӧ��Ʊ��
	private long ticketCount1;
	private long ticketCount2;
	//������
	private Object cinema1,cinema2;
	
	public Cinema(){
		ticketCount1 = 20;
		ticketCount2 = 20;
		cinema1 = new Object();
		cinema2 = new Object();
	}
	
	/**
	 * 1����Ʊ
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
	 * 2����Ʊ
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
	 * 1����Ʊ
	 * @param count Ʊ�� 
	 * @return
	 */
	public boolean returnTicket01(int count){
		synchronized(cinema1){
				ticketCount1 +=count;
				return true;
		}
	}
	/**
	 * 2����Ʊ
	 * @param count Ʊ��
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
