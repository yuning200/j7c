/* 
 * @(#)MyLogger.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f05;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ÏÂÎç3:37:21 $
 */
public class MyLogger {

	private static Handler handler;
	
	public static Logger getLogger(String name){
		Logger log = Logger.getLogger(name);
		log.setLevel(Level.ALL);
		try {
			if(handler == null){
				handler = new FileHandler("temp1.log");
				Formatter formatter = new MyFormatter();
				handler.setFormatter(formatter);
			}
			
			if(log.getHandlers().length == 0){
				log.addHandler(handler);
			}
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		return log;
	}
}
