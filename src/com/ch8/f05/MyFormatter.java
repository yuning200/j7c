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
 * @version $Revision: 1.0 $, $Date: 2014-7-10 ����3:24:58 $
 */
public class MyFormatter extends Formatter {


	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder();
		builder.append("["+record.getLevel()+"] - ");  //getLevel:ȡ��־��Ϣ�������� Level.SEVERE
		builder.append(new Date(record.getMillis())+" ��"); //��ȡ�Դ� 1970 ���Ժ���Ϊ��λ���¼�ʱ��
		builder.append(record.getSourceClassName()+"."+record.getSourceMethodName()+" ��");  //getSourceClassName :��ȡ������־������������  ,getSourceMethodName :��ȡ�����ܣ�������־����ķ���������
		builder.append(record.getMessage()+"\n"); //getMessage:��ȡ���ػ����ʽ��֮ǰ�ġ�ԭʼ����־��Ϣ
		return builder.toString();
	}
}
