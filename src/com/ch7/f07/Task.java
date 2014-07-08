package com.ch7.f07;

public class Task extends MyWorkerTask{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6368413995026370779L;
	
	private int[] array;
	private int start,end;

	public Task(String name,int[] array,int start,int end) {
		super(name);
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void computer() {
		if(end-start>100){
			int mid = (end+start)/2;
			Task t1 = new Task(this.getName()+"1", array, start, mid);
			Task t2 = new Task(this.getName()+"2", array, mid, end);
			invokeAll(t1, t2);
		}else{
			for (int i = start; i < end; i++) {
				array[i]++;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
