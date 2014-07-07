package com.ch7.f03;

import java.util.Date;

public class MyThread extends Thread {
	
	private Date creationDate;
	private Date startDate;
	private Date endDate;
	public MyThread(Runnable runn,String name){
		super(runn, name);
		setCreationDate();
	}
	
	@Override
	public void run(){
		setStartDate();
		super.run();
		setEndDate();
	}
	
	public void setCreationDate() {
		this.creationDate = new Date();
	}
	public void setStartDate() {
		this.startDate =  new Date();
	}
	public void setEndDate() {
		this.endDate =  new Date();
	}
	
	public long getExecutionTime(){
		return this.endDate.getTime()-this.startDate.getTime();
	}
	

	@Override
	public String toString(){
		StringBuilder buffer=new StringBuilder();
		buffer.append(getName());
		buffer.append(": ");
		buffer.append(" Creation Date: ");
		buffer.append(creationDate);
		buffer.append(" : Running time: ");
		buffer.append(getExecutionTime());
		buffer.append(" Milliseconds.");
		return buffer.toString();
	}
}
