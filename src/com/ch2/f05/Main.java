package com.ch2.f05;

/**
 * 使用ReadWriteLock接口实现一个程序，使用它来控制访问一个存储两个产品价格的对象
	PricesInfo类，用它来存储两个产品价格的信息，实现设置价格和获取价格
	Reader类 ，将价格打印到控制台。读取10次。
	Writer类，修改价格，两个价格同时修改。修改3次，设置为随即数(Math.random()*10, Math.random()*8)
	Main ，5个线程获取价格，1个线程修改价格。
 * @author lvyj
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo(1,2);
		Reader[] readers = new Reader[5];
		Thread[] thArray = new Thread[5];
		for (int i = 0; i <5; i++) {
			readers[i] = new Reader(pricesInfo);
			thArray[i] = new Thread(readers[i]);
		}
		Writer writer = new Writer(pricesInfo);
		
		for (int i = 0; i <5; i++) {
			thArray[i].start();
		}
		new Thread(writer).start();
	}
}
