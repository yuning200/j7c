package com.ch5.f01;

import java.util.List;
import java.util.concurrent.RecursiveAction;


public class Task extends RecursiveAction {

	private static final long serialVersionUID = -4506943128796748354L;
	private List<Product> products;
	private int first;
	private int end;
	private double increment;
	
	public Task(List<Product> products,int first,int end,double increment) {
		this.products = products;
		this.first = first;
		this.end = end;
		this.increment = increment;
	}

	@Override
	protected void compute() {
		if((end -first)<10){
			updatePrices();
		}else{
			int middle = (first+end)/2;
			System.out.printf("Task: Pending tasks: %s\n",getQueuedTaskCount());
			Task task1 = new Task(products, first, middle+1, increment);
			Task task2 = new Task(products, middle+1, end, increment);
			invokeAll(task1, task2);
		}
	}

	private void updatePrices() {
		for (int i = first; i < end; i++) {
			Product product = products.get(i);
			product.setPrice(product.getPrice()*(1+increment));
		}
	}

}
