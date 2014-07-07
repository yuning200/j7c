package com.ch6.f08;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Decrementer implements Runnable {
	private AtomicIntegerArray array;

	public Decrementer(AtomicIntegerArray array) {
		this.array = array;
	}

	@Override
	public void run() {
		for (int i = 0; i < array.length(); i++) {
			this.array.getAndDecrement(i);
			//getAndDecrement(int i)   以原子方式将索引 i 的元素减 1。
		}
	}
}
