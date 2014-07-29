/* 
 * @(#)Main.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch7.f09;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ����9:54:05 $
 */
public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements
		TransferQueue<E> {

	private static final long serialVersionUID = -8847142102913925687L;

	private AtomicInteger counter;
	private LinkedBlockingQueue<E> queue;
	private ReentrantLock lock;
	public MyPriorityTransferQueue(){
		this.counter = new AtomicInteger(0);
		this.queue = new LinkedBlockingQueue<>();
		this.lock = new ReentrantLock();
	}
	
	/**
	 * ���Խ�Element ������У�������Ϊ�շ���false,���򷵻�true
	 * 
	 */
	@Override
	public boolean tryTransfer(E e) {
		lock.lock();
		boolean value;
		if(counter.get()==0){
			value = false;
			
		}else{
			put(e);
			value = true;
		}
		lock.unlock();
		return value;
	}

	/**
	 *  * Transfer an element to the consumer. If there is a consumer waiting,
	 * puts the element on the queue and return the true value. Else, puts the
	 * value in the transfered queue and returns the false value. In this case, the
	 * thread than makes the call will be blocked until a consumer takes the transfered
	 * elements
	 * 
	 * ��������ת��һ���ڵ㣬���������ڵȴ������ڵ������в�����true�����򽫽ڵ����ת�ƶ��в�����false��
	 * ����������߳̽�����֪��һ��������ȡ��ת�ƽڵ�
	 * 
	 * ע������ע����˵����true��false�����Ǳ��ط���void��
	 */
	@Override
	public void transfer(E e) throws InterruptedException {
		lock.lock();
		if(counter.get()!=0){
			put(e);
			lock.unlock();
		}else{
			queue.add(e);
			lock.unlock();
			synchronized (e) {
				e.wait();
			}
		}
		
	}

	/**
	 * This method tries to transfer an element to a consumer waiting a maximum period
	 * of time. If there is a consumer waiting, puts the element in the queue. Else,
	 * puts the element in the queue of transfered elements and wait the specified period of time
	 * until that time pass or the thread is interrupted.
	 * 
	 *�����ȴ��涨ʱ���ڣ�  ����ת��һ���ڵ�������ߡ����������ڵȴ���������С�
	 *�������ת�ƶ��У��ڵȴ��涨ʱ���ֱ��ʱ����������߳��նˡ�
	 * 
	 */
	
	
	@Override
	public boolean tryTransfer(E e, long timeout, TimeUnit unit)
			throws InterruptedException {
		lock.unlock();
		if(counter.get()!=0){
			put(e);
			lock.unlock();
			return true;
		}else{
			queue.add(e);
			long waitTime = TimeUnit.MILLISECONDS.convert(timeout, unit);
			lock.unlock();
			e.wait(waitTime);
			lock.lock();
			if(queue.contains(e)){
				queue.remove(e);
				lock.unlock();
				return false;
			}else{
				lock.unlock();
				return true;
			}
			
		}
	}

	/**
	 * Method that returns if the queue has waiting consumers
	 * ���������еȴ������ߵ����
	 */
	@Override
	public boolean hasWaitingConsumer() {
		return (counter.get()!=0);
	}

	
	/**
	 * Method that returns the number of waiting consumers
	 * 
	 * ���صȴ������ߵ�����
	 */
	@Override
	public int getWaitingConsumerCount() {
		return counter.get();
	}

	/**
	 * Method that returns the first element of the queue or is blocked if the queue
	 * is empty. If there is transfered elements, takes the first transfered element and
	 * wake up the thread that is waiting for the transfer of that element. Else, takes the
	 * first element of the queue or is blocked until there is one element in the queue.
	 * 
	 * ���ض����е�һ���ڵ�����Ϊ����������ת��Ԫ�أ�ת�Ƶ�һ���ڵ㲢����ת�Ƶ�ǰ�ڵ���̡߳�
	 * ����ת�Ƶ�һ��Ԫ�ػ����������߳�֪�������в�Ϊ��
	 * 
	 * 
		lock.lock();
		counter.incrementAndGet();
		E value=transfered.poll();
		if (value==null) {
			lock.unlock();
			value=super.take();
			lock.lock();
		} else {
			synchronized (value) {
				value.notify();
			}
		}
		counter.decrementAndGet();
		lock.unlock();
		return value;
	
	 */
	@Override
	public E take() throws InterruptedException {
		
		lock.lock();
		counter.incrementAndGet();
		E value = queue.poll();
		if(value == null){
			lock.unlock();
			value=super.take();
			lock.lock();
			
		}else{
			synchronized (value) {
				value.notify();
			}
		}
		counter.decrementAndGet();
		lock.unlock();
		return value;
	}
	
	

}
