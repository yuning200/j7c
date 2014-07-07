package com.ch2.f07;

public class FileMock {
	private String[] content;
	private int index;

	public FileMock(int size, int length) {
		index = 0;
		content = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuffer sbu = new StringBuffer(length);
			for(int j = 0; j < size; j++){
				int rum = (int) (Math.random()*225);
				sbu.append((char)rum);
			}
			content[i] = sbu.toString(); 
		}
	}
	
	public boolean hasFileMock(){
		return index<content.length;
	}
	
	public String getContent(){
		if(hasFileMock()){
			System.out.println("Mock: "+(content.length-index));
			return content[index++];
		}
		return null;
	}
}
