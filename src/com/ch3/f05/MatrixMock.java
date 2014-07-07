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
	 * @param row       ��������
	 * @param lenth     ÿ�г���
	 * @param number    ��ѯ����
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
	 * ��ȡָ���е�����
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
