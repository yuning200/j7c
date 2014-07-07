package com.ch3.f05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable{
	private int firstRow;
	private int lastRow;
	private int number;
	private MatrixMock mock;
	private Results results;
	private final CyclicBarrier barrier;
	

	public Searcher(int firstRow,int lastRow,int number,MatrixMock mock,Results results,CyclicBarrier barrier) {
		this.firstRow =firstRow;
		this.lastRow = lastRow;
		this.number = number;
		this.mock = mock;
		this.results = results;
		this.barrier = barrier;
	}

	
	

	
	@Override
	public void run() {
		
		System.out.printf("%s: Processing lines from %d to %d.\n",Thread.currentThread().getName(),firstRow,lastRow);
		for (int i = firstRow; i < lastRow; i++) {
			int counter = 0;
			int[] rows = mock.getRow(i); 
			for (int j = 0; j < rows.length; j++) {
				if(rows[j]==number ){
					counter++;
				}
			}
			results.setData(i, counter);
		}
		System.out.printf("%s: Lines processed.\n",Thread.currentThread().getName());	
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
