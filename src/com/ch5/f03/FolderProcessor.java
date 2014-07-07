package com.ch5.f03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1021727777514997508L;
	private String path;
	private String extension;
	public FolderProcessor(String path,String extension) {
		this.path = path;
		this.extension = extension;
	}
	@Override
	protected List<String> compute() {
		List<String> lists = new ArrayList<>();
		List<FolderProcessor> folderList = new ArrayList<>();
		File file = new File(path);
		File[] files = file.listFiles();
		if(files != null){
			for (File f:files) {
				if(f.isDirectory()){
					FolderProcessor folder = new FolderProcessor(f.getAbsolutePath(), extension);
					folder.fork();
					folderList.add(folder);
					
				}else{
					if(checkFile(f.getName())){
						lists.add(f.getAbsolutePath());
					}
				}
			}
			
			if (folderList.size()>50) {
				System.out.printf("%s: %d tasks ran.\n",file.getAbsolutePath(),folderList.size());
			}
			addResultsFromTasks(lists,folderList);
			
			
		}
		return lists;
	}
	private void addResultsFromTasks(List<String> lists,
			List<FolderProcessor> folderList) {
		for (FolderProcessor f :folderList) {
			lists.addAll(f.join());
		}
	}
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}
}
