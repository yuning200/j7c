package com.ch7.f05;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyScheduledTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
	
	private RunnableScheduledFuture<V> task;
	private ScheduledThreadPoolExecutor executor;
	private long periodic;
	private long startDate;

	public MyScheduledTask(Runnable runnable,V result,RunnableScheduledFuture<V> task,ScheduledThreadPoolExecutor executor) {
		super(runnable,result);
		this.task = task;
		this.executor = executor;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		if(!isPeriodic()){
			return task.getDelay(unit);
		}else{
			if(startDate == 0){
				return task.getDelay(unit);
			}else{
				Date newDate = new Date();
				long differ = startDate-newDate.getTime();
				return unit.convert(differ, TimeUnit.MILLISECONDS);
			}
		}
		
	}

	@Override
	public int compareTo(Delayed o) {
		return task.compareTo(o);
	}

	@Override
	public boolean isPeriodic() {
		return task.isPeriodic();
	}
	
	public void setPeriodic(long periodic){
		this.periodic = periodic;
	}

	@Override
	public void run() {
		if(isPeriodic() && (!executor.isShutdown())){
			Date newDate = new Date();
			startDate=newDate.getTime()+periodic;
			executor.getQueue().add(task);
		}
		System.out.printf("beg,-Pre-MyScheduledTask: %s\n",new Date());
		System.out.printf("MyScheduledTask: Is Periodic: %s\n",isPeriodic());
		super.runAndReset();
		System.out.printf("end,-Post-MyScheduledTask: %s\n",new Date());
	}
}
