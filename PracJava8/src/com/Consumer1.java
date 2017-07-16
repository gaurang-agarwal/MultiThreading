package com;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Consumer1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ArrayList<Integer> list = new ArrayList<Integer>();

Thread producerThread=new Thread(new Producer(list));
Thread consumerThread=new Thread(new Consumer(list));		
		
consumerThread.start();
TimeUnit.SECONDS.sleep(1);
producerThread.start();
try{
	
	producerThread.join();
	consumerThread.join();
}
catch(Exception e){
	e.printStackTrace();
}


	}

}


class Producer implements Runnable
{
	ArrayList<Integer> list;
	public Producer(ArrayList<Integer> list) {
		// TODO Auto-generated constructor stub
		this.list=list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			try{
				//synchronized (list) 
				{
					
						
					while(list.size()==6)
					{
						System.out.println("List is Full waiting now ");
						//list.wait();
					}
					
					TimeUnit.SECONDS.sleep(3);
					System.out.println("Adding to list "+i);
					list.add(i);
					//list.notifyAll();
			}
					
				}
			catch (InterruptedException e){
				e.printStackTrace();
			}
			
			
		}
	}
}

class Consumer implements Runnable
{
	ArrayList<Integer> list;
	public Consumer(ArrayList<Integer> list) {
		// TODO Auto-generated constructor stub
		this.list=list;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			try{
				//synchronized (list) 
				{
					while(list.size()==0)
					{
						System.out.println("List is empty waiting now ");
						//list.wait();
					}
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Removing from list "+i);
					list.remove(new Integer(i));
					//list.notifyAll();
			}
					
				}
			catch (InterruptedException e){
				e.printStackTrace();
			}
			
			
		}
	}
}

