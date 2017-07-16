package com;

import java.util.concurrent.TimeUnit;

public class ObjectCreationCheck {

	static ObjectCreationCheck instance=null;
	
	public static ObjectCreationCheck getInstance(int n) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName()+" is before sleep ");
		
		TimeUnit.SECONDS.sleep(n*2);
		System.out.println(Thread.currentThread().getName()+" is after sleep ");
		
		if(instance==null)
		{
			System.out.println(Thread.currentThread().getName()+" is creating instance ");
			
			instance = new ObjectCreationCheck(n);
			System.out.println(Thread.currentThread().getName()+" after instance ");
			
		}
		System.out.println(Thread.currentThread().getName()+" returning ");
		
		return instance;
	}
	
	
	public ObjectCreationCheck(int n) throws InterruptedException {
		// TODO Auto-generated constructor stub
		System.out.println(Thread.currentThread().getName()+" is indide constructor ");
		TimeUnit.SECONDS.sleep(n*5);
		System.out.println(Thread.currentThread().getName()+" object created ");
		
	}
	
	
	public static void main(String[] args) {
		
		new Thread(()-> {try { ObjectCreationCheck.getInstance(2);} catch(Exception e){}  }, "One").start();
		new Thread(()-> {try { ObjectCreationCheck.getInstance(3);} catch(Exception e){}  }, "Two").start();
		new Thread(()-> {try { ObjectCreationCheck.getInstance(7);} catch(Exception e){}  }, "Three").start();
		
	}
}
