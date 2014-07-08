package com.ch7.f07;

import java.util.Date;
import java.util.concurrent.ForkJoinTask;

public abstract class MyWorkerTask extends ForkJoinTask<Void> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 277118812012593055L;
	private String name;
	public MyWorkerTask(String name){
		this.name = name;
	}

	@Override
	public Void getRawResult() {
		return null;
	}

	@Override
	protected void setRawResult(Void value) {
	}

	@Override
	protected boolean exec() {
		Date startDate = new Date();
		computer();
		Date finishDate  = new Date();
		long diff = finishDate.getTime() -startDate.getTime();
		System.out.printf("MyWorkerTask: %s : %d Milliseconds to complete.\n",name,diff);
		return true;
	}
	
	protected abstract void  computer();
	
	public String getName(){
		return name;
	}

}
