package com.ch5.f02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class LineTask extends RecursiveTask<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7629653954365301666L;
	private String[] line;
	private int start,end;
	private String word;
	
	public LineTask(String[] line,int start,int end,String word) {
		this.line = line;
		this.start = start;
		this.end = end;
		this.word = word;
	}

	@Override
	protected Integer compute() {
		int result=0;
		if((end-start)<100){
			result  = count(line,start,end,word);
		}else{
			int mid = (end+start)/2;
			LineTask lineTask1 = new LineTask(line, start, mid, word);
			LineTask lineTask2 = new LineTask(line, mid, end, word);
			invokeAll(lineTask1,lineTask2);
			try {
				result = groupResult(lineTask1.get(),lineTask2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private int count(String[] line, int start, int end, String word) {
		int count = 0;
		for (int i = start; i <end; i++) {
			if(line[i].equals(word)){
				count++;
			}
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return count;
	}

	private int groupResult(Integer integer, Integer integer2) {
		return integer+integer2;
	}

}
