package com.ch3.f05;

public class Results {
	private int[] data;

	public Results(int size) {
		data = new int[size];
	}

	public int[] getData() {
		return data;
	}

	public void setData(int position, int value) {
		data[position] = value;
	}
}
