package com.ch3.f05;

import java.util.concurrent.CyclicBarrier;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ROWS=10000;
		final int NUMBERS=1000;
		final int SEARCH=5; 
		final int PARTICIPANTS=5;
		final int LINES_PARTICIPANT=2000;
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Results results = new Results(ROWS);
		Grouper grouper = new Grouper(results);
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS,grouper);
		
		for(int i=0;i<PARTICIPANTS;i++){
			Searcher searcher = new Searcher(i*LINES_PARTICIPANT, (i*LINES_PARTICIPANT)+LINES_PARTICIPANT, SEARCH, mock, results, barrier);
			Thread thread = new Thread(searcher);
			thread.start();
		}
		System.out.printf("Main: The main thread has finished.\n");
	}
}
