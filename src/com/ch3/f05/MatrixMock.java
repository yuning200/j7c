package com.ch3.f05;

import java.util.Random;

/**
 * 
 * @author lvyj
 *
 */
public class MatrixMock {
	
	private int[][] data ;

	/**
	 * 
	 * @param row       数组行数
	 * @param lenth     每行长度
	 * @param number    查询数字
	 */
	public MatrixMock(int row,int lenth,int number) {
		int count = 0;
		data = new int[row][lenth];
		Random random = new Random();
		for(int i =0;i<row;i++){
			for(int j =0;j<lenth;j++){
				data[i][j] = random.nextInt(10);
				if(data[i][j] == number){
					count++;
				}
			}
		}
		System.out.printf("Mock: There are %d ocurrences of number in generated data.\n",count,number);
	}

	/**
	 * 获取指定行的数据
	 * @param row
	 * @return
	 */
	public int[] getRow(int row){
		if(row>=0 && (row<data.length)){
			return data[row];
		}
		return null;
	}
}
