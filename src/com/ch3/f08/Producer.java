package com.ch3.f08;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable{
	private List<String> buffer;
	private Exchanger<List<String>> exchanger ;

	public Producer(List<String> buffer,Exchanger<List<String>> exchanger ) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		int cycle = 1;
		for (int i = 0; i <10; i++) {
			System.out.printf("Producer: Cycle %d\n",cycle);
			for (int j = 0; j <10; j++) {
				String message = "Event "+((i*10)+j);
				System.out.printf("Producer content: %s\n",message);
				buffer.add(message);
			}
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Producer size: %d\n",buffer.size());
			cycle++;
		}
	}
}
