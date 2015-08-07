package filesearch;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
public class FileSearcher {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Producer producer = new Producer("/home/appnetix/cvs/");
		Thread thread= new Thread(producer);
		thread.start();
		TimeUnit.SECONDS.sleep(5);
		producer.setForceStop(true);
		
	}
}
class Producer implements Runnable{
	BlockingQueue<File> queue= new ArrayBlockingQueue<File>(10024);
	String rootPath;
	private volatile boolean forceStop=false;
	public void setForceStop(boolean forceStop) {
		this.forceStop = forceStop;
	}
	public boolean getForceStop() {
		return forceStop;
	}
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
		System.out.println(">>>>>>>>>>>Consumer Started<<<<<<<<<<");
		File file = new File(rootPath);
		
		try {
			produce(file);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(">>>>Produce Stopped Forcefully<<<<<<");
		}
		
		
		try {
			System.out.println(">>>>>>>Produce Completed<<<<<<<<<<<<<<<");
			consumerThread.join();
			FileWriter writer = new FileWriter("/home/appnetix/Desktop/wring.txt");
				writer.write(consumer.getFileList()+"");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(">>>>>>>>>>Producer Interrupted<<<<<<<<<");
			consumerThread.interrupt();
		}
		finally{
			System.out.println(">>>>>>In Finally<<<<<<<");
		}
		
	}
	
	List <String> fileName= new ArrayList<String>();
	public List<String> getFileList(){
		return fileName;
	}
	public void  setFileList(List<String> fileName){
		this.fileName=fileName;
	}
	
	private void produce(File file) throws Exception {
		// TODO Auto-generated method stub
		if(getForceStop()){
			throw new Exception();
		}
		if(file.isDirectory()){
			queue.offer(file);
			for(File filelist:file.listFiles(new MyFileFilter())){
					produce(filelist);
			}
		}
	}
}
class Consumer implements Runnable{
	BlockingQueue<File> queue=null;
	private volatile boolean forceStop=false;
	public Consumer(BlockingQueue<File> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}
	List <String> fileName= new ArrayList<String>();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			while(true){
				File directory=queue.poll(5,TimeUnit.SECONDS);
				if(directory!=null){
				String [] fileList=directory.list(new MyFileNameFilter(".java"));
				for(String file:fileList){
					fileName.add(file+"\n");
				}
				}
				else {
					System.out.println("queue>>>>>>>>>"+queue);
					break;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			System.out.println(">>>Consumer Thread Interrupted<<<");
		}
	}
public List<String> getFileList(){
		return fileName;
	}

public void setForceStop(boolean forceStop){
	this.forceStop=forceStop;
}

}
class MyFileNameFilter implements FilenameFilter{
	String pattern;
	MyFileNameFilter(String pattern) {
		// TODO Auto-generated method stub
		this.pattern=pattern;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(pattern);
	}
}


class MyFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.isDirectory();
		
	}
	
}
