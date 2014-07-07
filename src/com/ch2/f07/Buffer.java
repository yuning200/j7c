package com.ch2.f07;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private int maxSize;
	private LinkedList<String> buffer;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;

	public Buffer() {
		maxSize = 20;
		buffer = new LinkedList<String>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line){
		lock.lock();
		try {
			while(buffer.size()>=maxSize){
				try {
					space.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread()
					.getName(), buffer.size());
			lines.signalAll();
			
		} finally {
			lock.unlock();
		}
	}
	
	public String get(){
		String line = null;
		lock.lock();
		try{
			while((buffer.size()==0) && hasPendingLines()){
				try {
					lines.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(this.hasPendingLines()){
				line = buffer.poll();
				System.out.printf("%s: GET Line: %d\n", Thread.currentThread()
						.getName(), buffer.size());
				space.signalAll();
			
			}
		}finally{
			lock.unlock();
		}
		return line;
	}
	
	public boolean hasPendingLines(){
		return pendingLines||buffer.size()>0;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}
}
