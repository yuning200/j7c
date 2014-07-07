package com.ch3.f07;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
	
	private Phaser phaser;

	public Student(Phaser phaser) {
		this.phaser =phaser;
	}

	@Override
	public void run() {
		System.out.printf("%s: Has arrived to do the exam. %s\n",Thread.currentThread().getName(),new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s: Is going to do the first exercise. %s\n",Thread.currentThread().getName(),new Date());
		doExercise1();
		System.out.printf("%s: Has done the first exercise. %s\n",Thread.currentThread().getName(),new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s: Is going to do the second exercise. %s\n",Thread.currentThread().getName(),new Date());
		doExercise2();
		System.out.printf("%s: Has done the second exercise. %s\n",Thread.currentThread().getName(),new Date());
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s: Is going to do the third exercise. %s\n",Thread.currentThread().getName(),new Date());
		doExercise3();
		System.out.printf("%s: Has finished the exam. %s\n",Thread.currentThread().getName(),new Date());
		phaser.arriveAndAwaitAdvance();
	}
	private void doExercise1() {
		long sleepTime = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private void doExercise2() {
		long sleepTime = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private void doExercise3() {
		long sleepTime = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
