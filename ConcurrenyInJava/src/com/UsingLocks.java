package com;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UsingLocks {
	Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		UsingLocks job = new UsingLocks();
		Thread [] threads= new Thread[5];
		for(int i=0;i<5;i++){
			threads[i]= new Thread(new LockTask(job));
		}
		for(int i=0;i<5;i++){
			threads[i].start();
		}
		
	}
	
	public void lockingJob() {
		while(true){
			System.out.println("Thread "+Thread.currentThread().getName()+" trying to Acquire lock");
		if(lock.tryLock()){
			break;
		} else
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		{
		try {
		int time=new Random().nextInt(10)+3;
		System.out.println("Thread "+Thread.currentThread().getName()+" Acquired lock for "+time+" seconds.");
		TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Now releasing lock "+Thread.currentThread().getName());
		lock.unlock();
		}
		System.out.println("After Unlock "+Thread.currentThread().getName());
		
		
		
	}
	
	
	

}

class LockTask implements Runnable{
	UsingLocks job;
	public LockTask(UsingLocks job) {
		// TODO Auto-generated constructor stub
		this.job=job;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		job.lockingJob();
		
		
	}
	
	
	
	
	
	
	
}

