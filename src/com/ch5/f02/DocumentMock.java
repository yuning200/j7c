package com.ch5.f02;

import java.util.Random;

public class DocumentMock {
	private String words[]={"the","hello","goodbye","packt","java","thread","pool","random","class","main"};
	
	/**
	 * 
	 * @param numLines
	 * @param numWord
	 * @param word
	 * @return
	 */
	public String[][] generateDocument(int numLines,int numWord,String word){
		int count = 0;
		Random random = new Random();
		String[][] document = new String[numLines][numWord];
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j <numWord; j++) {
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if(document[i][j].equals(word)){
					count++;
				}
			}
		}
		System.out.printf("DocumentMock: The word appears %d times in the document.\n",count);
		return document;
	}
}
