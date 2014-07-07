package com.ch4.f04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String user = "test";
		String password = "test";
		UserValidator userVa1 = new UserValidator("LDAP");
		UserValidator userVa2 = new UserValidator("DataBase");
		TaskValidator taskValidator1 = new TaskValidator(userVa1, user, password);
		TaskValidator taskValidator2 = new TaskValidator(userVa2, user, password);
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		List<TaskValidator> tasks = new ArrayList<>();
		tasks.add(taskValidator1);
		tasks.add(taskValidator2);
		String result;
		try {
			result = executor.invokeAny(tasks);
			System.out.printf("Main: Result: %s\n",result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.printf("Main: End of the Execution\n");
	}
}
