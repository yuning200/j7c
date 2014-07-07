package com.ch3.f06;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable{
	private String initPath; //搜索的文件夹路径
	private String end; //搜索的结尾符
	private Phaser phaser;
	private List<String> results;

	public FileSearch(String initPath,String end,Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<String>();
	}
	
	private void directoryProcess(File file){
		File[] files = file.listFiles();
		if(files != null){
			for(File f:files){
				if(f.isDirectory()){
					directoryProcess(f);
				}else{
					 fileProcess(f);

				}
			}
		}
		
	}

	private void fileProcess(File file) {
		if(file.getName().endsWith(end)){
			results.add(file.getAbsolutePath());
		}
	}
	
	private void filterResults(){
		if(results == null || results.size()<=0){
			return;
		}
		List<String> newResults = new ArrayList<String>();
		long actualDate = new Date().getTime();
		for(String filePath:results){
			File file = new File(filePath);
			long lastModifyTime = file.lastModified();
			if(actualDate-lastModifyTime<TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)){
				newResults.add(filePath);
			}
		}
		results = newResults;
	}
	
	private boolean checkResults(){
		if(results.isEmpty()){
			System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		}else{
			System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(),results.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	private void showInfo(){
		for(String filePath : results){
			File file = new File(filePath);
			System.out.printf("%s,%s \n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s, begin: \n",Thread.currentThread().getName());
		File file = new File(initPath);
		if(file.isDirectory()){
			directoryProcess(file);
		}
		if(!checkResults()){
			return;
		}
		filterResults();
		
		if(!checkResults()){
			return;
		}
		
		showInfo();
		phaser.arriveAndDeregister();
		System.out.printf("%s,end: \n",Thread.currentThread().getName());
		
		
	}
}
