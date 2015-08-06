package filesearch;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FileSearcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Producer producer = new Producer("/home/gaurang/workspace/");
		Thread thread= new Thread(producer);
		thread.start();
		
	}
	
}


class Producer implements Runnable{
	BlockingQueue<File> queue= new ArrayBlockingQueue<File>(1024);
	 String rootPath;
	public Producer(String rootPath) {
		// TODO Auto-generated constructor stub
	this.rootPath=rootPath;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	Consumer consumer = new Consumer(queue);	
	Thread consumerThread= new Thread(consumer);
		consumerThread.start();
		System.out.println("><Consumer Started<<<<<<<<<<");
	File file = new File(rootPath);
	produce(file);
	try {
		Thread.sleep(5000);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(">>>>>>>>consumer>>>>>>>>>>"+consumer.getFileList());
	
}

private void produce(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory()){
			queue.add(file);
			for(File filelist:file.listFiles()){
				if(filelist.isDirectory()){
					produce(filelist);
				}
			}
		
		}
		
		
		
	}
}
class Consumer implements Runnable{

	BlockingQueue<File> queue=null;
	
	public Consumer(BlockingQueue<File> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}
	List <String> fileName= new ArrayList<String>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
			while(queue.size()>0){
			File directory=queue.take();
			String [] fileList=directory.list(new MyFileFilter(".java"));
			for(String file:fileList){
				fileName.add(file);
			}
			
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public List<String> getFileList(){
		return fileName;
	}
	
}

class MyFileFilter implements FilenameFilter{
String pattern;
	MyFileFilter(String pattern) {
		// TODO Auto-generated method stub
this.pattern=pattern;
		
	}
	
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(pattern);
	}
	
}

