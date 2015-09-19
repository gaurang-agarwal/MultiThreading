package com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerBlockingQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(3);
		Thread producer = new Thread(new BQProducer(bQueue));
		Thread consumer = new Thread(new BQConsumer(bQueue));
		producer.start();
		consumer.start();
		try{
			producer.join();
			consumer.join();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class BQProducer implements Runnable{

	BlockingQueue<String> bQueue; 
	
	public BQProducer(BlockingQueue<String> bQueue) {
		// TODO Auto-generated constructor stub
		this.bQueue=bQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Going To add "+i);
				bQueue.offer(new Integer(i).toString(),5,TimeUnit.SECONDS);
				System.out.println("Added "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Producer Ended");
		
		
	}
	
}


class BQConsumer implements Runnable{

	BlockingQueue<String> bQueue; 
	
	public BQConsumer(BlockingQueue<String> bQueue) {
		// TODO Auto-generated constructor stub
		this.bQueue=bQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String element = new String();
		
		try {
			
		while(element!=null){	
			element=bQueue.poll(3, TimeUnit.SECONDS);
			System.out.println("Consumed::"+element);
			TimeUnit.SECONDS.sleep(5);
			
		}
		System.out.println("Consumer Ended");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}