/* 
 * @(#)MyLock.java    Created on 2014-7-9
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f01;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-9 ÉÏÎç11:52:34 $
 */
public class MyLock extends ReentrantLock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1258522195852426694L;

	public String getOwnerName(){
		if(this.getOwner() == null){
			return "None";
		}else{
			return this.getOwner().getName();
		}
	}
	
	public Collection<Thread> getThreads(){
		return this.getQueuedThreads();
	}
}
