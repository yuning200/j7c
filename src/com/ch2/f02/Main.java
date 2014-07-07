package com.ch2.f02;

/**
 * ���ģ��һ�ҵ�ӰԺ��������Ļ��������Ʊ������һ����Ʊ��������Ʊ����������������ӰԺ������һ��������������������
	������ÿ����ӰԺ�����ϯλ�������Ƕ���������
	
	��ӰԺ:Cinema(������Ʊ����Ʊ) ��Ʊ�ڣ�TicketOfficeFirst,TicketOfficeSercond
	
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
