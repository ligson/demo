package demo.mina.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileObject {
	//fileCount:5;size:1024;0000000;
	private int fileCount;
	private List<File> files = new ArrayList<File>();
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public void addFile(File file){
		files.add(file);
	}
	
	
}
