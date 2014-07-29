package com.ch7.f09;

public class Event implements Comparable<Event>{
	private String thread;
	private int priority;
	public Event(String thread,int priority) {
		this.thread = thread;
		this.priority = priority;
	}
	@Override
	public int compareTo(Event o) {
		if(this.priority>o.priority){
			return -1;
		}else if(this.priority<o.priority){
			return 1;
		}
		return 0;
	}
	public String getThread() {
		return thread;
	}
	public int getPriority() {
		return priority;
	}
}
