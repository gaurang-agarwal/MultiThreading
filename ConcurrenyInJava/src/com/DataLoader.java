package com;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DataLoader {
public static void main(String [] args) 
{
Thread dataLoader = new Thread(new DataLoaderThread());	
dataLoader.start();
	for(int i=0;i<50;i++){
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("State of DataLoader Thread "+dataLoader.getState());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}

class DataLoaderThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("************DataLoader thread Started****************");
		
		Thread intialiation = new Thread(new Intialization());
	intialiation.start();
	try {
		TimeUnit.SECONDS.sleep(3);
		System.out.println("***********Calling join***********");
		intialiation.join(1000*7);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	System.out.println("************DataLoader thread Finished****************");
	
	
	}
	
}


class Intialization implements Runnable {

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		System.out.println("************Intialization thread Started****************");
		for(int i=0;i<5;i++){
			System.out.println("Running Initailization Thread>>"+Calendar.getInstance().getTime());
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("************Intialization thread Completed****************");
	}
	
}






