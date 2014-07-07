package com.ch5.f02;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
public class DocumentTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 787598936971397304L;
	
	private String[][] document;
	private int start,end;
	private String word;

	public DocumentTask(String[][] document,int start ,int end,String word) {
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}

	@Override
	protected Integer compute() {
		int result = 0;
		if((end-start)<10){
			result = processLines(document,start , end, word);
		}else{
			int mid = (start+end)/2;
			DocumentTask task1 = new DocumentTask(document, start, mid, word);
			DocumentTask task2 = new DocumentTask(document, mid, end, word);
			invokeAll(task1,task2);
			try {
				result = groupResult(task1.get(),task2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	private int processLines(String[][] document, int start, int end,
			String word) {
		List<LineTask> tasks = new ArrayList<LineTask>();
		for (int i = start ; i <end; i++) {
			LineTask task = new LineTask(document[i], 0, document[i].length, word);
			tasks.add(task);
		}
		invokeAll(tasks);
		
		int result  = 0;
		for (int i = 0; i < tasks.size(); i++) {
			LineTask task = tasks.get(i);
			try {
				result = result+task.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	private int groupResult(Integer integer, Integer integer2) {
		return integer+integer2;
	}
}
