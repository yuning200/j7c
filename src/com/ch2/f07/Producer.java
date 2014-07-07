package com.ch2.f07;

public class Producer implements Runnable{
	private FileMock fileMock;
	private Buffer buffer;

	public Producer(FileMock fileMock, Buffer buffer) {
		this.fileMock = fileMock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		buffer.setPendingLines(true);
		while(fileMock.hasFileMock()){
			String line = fileMock.getContent();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}
}
