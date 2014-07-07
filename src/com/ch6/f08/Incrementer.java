package com.ch6.f08;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Incrementer implements Runnable {

	private AtomicIntegerArray array;
	public Incrementer(AtomicIntegerArray array) {
		this.array = array;
	}

	@Override
	public void run() {
		for (int i = 0; i < array.length(); i++) {
			array.getAndIncrement(i);
			//getAndIncrement(int i)  以原子方式将索引 i 的元素加 1。
		}
	}
}
