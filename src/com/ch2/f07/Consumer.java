package com.ch2.f07;

import java.util.Random;

public class Consumer implements Runnable{
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(buffer.hasPendingLines()){
			String line = buffer.get();
			processLine(line);
			
		}
		
	}
	
	private void processLine(String line){
		
		try {
			Random ran = new Random();
			Thread.sleep(ran.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
