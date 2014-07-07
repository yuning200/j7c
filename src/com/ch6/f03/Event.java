package com.ch6.f03;


public class Event implements Comparable<Event> {
	
	private int priority;
	private int thread;
	public Event(int priority,int thread){
		this.priority =priority ;
		this.thread = thread;
	}
	
	@Override
	public int compareTo(Event o) {
		if(this.priority>o.priority){
			return -1;
		}else if(this.priority<o.priority){
			return 1;
		}else{
		return 0;
		}
	}

	public int getPriority() {
		return priority;
	}

	public int getThread() {
		return thread;
	}
	
}
