package com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatches {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch latch = new CountDownLatch(5);
		Thread t= null;
		for(int i=1;i<=5;i++){
			t= new Thread(new Participants(latch), ""+i);
			t.start();
		}
		t= new Thread(new VideoConference(latch), "Video Conference");
		t.start();
		t.join();
				
		
		
		
	}

}


class Participants implements Runnable{
	
	final CountDownLatch latch;
	public Participants(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch=latch;
	}
	
	public void run() {
		
		try {
			System.out.println("Participant "+Thread.currentThread().getName() +" is trying to connect.");
			TimeUnit.SECONDS.sleep(Integer.parseInt(Thread.currentThread().getName())*2);
			latch.countDown();
			System.out.println("Participant "+Thread.currentThread().getName() +" has arrived.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}


class VideoConference implements Runnable{
	
	final CountDownLatch latch;
	public VideoConference(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch=latch;
	}
	
	public void run() {
		
		try {
			System.out.println("Waiting for users to arrive");
			latch.await();
			System.out.println("All Participants have arrived");
			System.out.println("Lock and Load");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

