package com.ch4.f04;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
	private UserValidator userValidator;
	private String name;
	private String password;

	public TaskValidator(UserValidator userValidator,String name,String password) {
		this.userValidator = userValidator;
		this.name = name;
		this.password = password;
	}

	@Override
	public String call() throws Exception {
		if(!userValidator.validate(name, password)){
			System.out.printf("%s: The user has not been found\n",userValidator.getName());
			throw new Exception("Error validating user");
		}
		System.out.printf("%s: The user has been found\n",userValidator.getName());
		return userValidator.getName();
	}

}
