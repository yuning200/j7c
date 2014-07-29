package com.test;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TestYsf();
		//testRandom();
		
		Test test = new Test();
		Map m1 = test.ObjectTest();
		Map m2 = test.ObjectTest();
		System.out.println(m1 == m2);

	}
	
	
	public static void testRandom(){
		Random random = new Random(47);
		int i = random.nextInt(100);
		int j = random.nextInt(100);
		System.out.println(i);
		System.out.println(j);
		
	}
	public static void testYsf(){
		InterruptedException  x = new InterruptedException ();
		ExecutionException  x1 = new ExecutionException(new RuntimeException());
	//	Exception e = x | x1 ;
	//	System.out.println();
	}
	
	public static void testArray(){
		int date[][] = new int[2][3];
		date[0][0] =1; 
		date[0][1] =2; 
		date[0][2] =3; 
		date[1][0] =4; 
		date[1][1] =5; 
		date[1][2] =6; 
		System.out.println(date.length);
		System.out.println(date[0].length);

	}
	
	public Map ObjectTest(){
		Map<String,String> map = new ConcurrentHashMap<>();
		//System.out.println("map:"+map.toString());
		return map;
		
		
	}

}
