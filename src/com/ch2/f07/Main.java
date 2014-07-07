package com.ch2.f07;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileMock fileMock = new FileMock(101,10);
		Buffer buffer = new Buffer();
		Producer producer = new Producer(fileMock,buffer);
		Thread prThread = new Thread(producer);
		
		//Consumer[] consumer = new Consumer(buffer)[3];
		//Thread[] thread = new Thread[3]; 
		for(int i=0;i<3;i++){
	    // thread[i] =
            new Thread( new Consumer(buffer)).start();
		}
		prThread.start();
		
		

	}

}
