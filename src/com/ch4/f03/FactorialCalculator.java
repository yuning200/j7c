package com.ch4.f03;

import java.util.concurrent.Callable;

public class FactorialCalculator  implements Callable<Integer>{
	private Integer number ;

	public FactorialCalculator(Integer number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int callint = number.intValue();
		int result = 1;
		if((callint == 0)||(callint == 1)){
			result = 1;
		}else{
			for (int i = 2; i < number; i++) {
				result *=i;
				Thread.sleep(20);
			}
		}
		System.out.printf("%s: %d\n",Thread.currentThread().getName(),result);
		return result;
	}

}
