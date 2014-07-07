package com.ch4.f01;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server  = new Server();
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task "+i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
