/* 
 * @(#)MyFormatter.java    Created on 2014-7-10
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.ch8.f05;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author lvyj
 * @version $Revision: 1.0 $, $Date: 2014-7-10 下午3:24:58 $
 */
public class MyFormatter extends Formatter {


	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder();
		builder.append("["+record.getLevel()+"] - ");  //getLevel:取日志消息级别，例如 Level.SEVERE
		builder.append(new Date(record.getMillis())+" ："); //获取自从 1970 年以毫秒为单位的事件时间
		builder.append(record.getSourceClassName()+"."+record.getSourceMethodName()+" ：");  //getSourceClassName :获取发出日志请求的类的名称  ,getSourceMethodName :获取（可能）发出日志请求的方法的名称
		builder.append(record.getMessage()+"\n"); //getMessage:获取本地化或格式化之前的“原始”日志消息
		return builder.toString();
	}
}
