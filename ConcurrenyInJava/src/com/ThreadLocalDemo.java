package com;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
for(int i=0;i<5;i++){
		Thread unsafe = new Thread(new ThreadSafe());
		unsafe.start();
		TimeUnit.SECONDS.sleep(2);
}
	}

}


class Unsafe implements Runnable
{
Date date = null;
	@Override
	public void run() {
		date= new Date();
		System.out.println(Thread.currentThread().getName()+" Start Time:"+date);
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" Endaa Time:"+date);
	}
	
	
}

class ThreadSafe implements Runnable
{
static ThreadLocal<Date> date = null;
	@Override
	public void run() {
		date= new ThreadLocal<Date>(){
			
			protected Date initialValue(){
				return new Date();
				}
				};
		Date startDate=date.get();		
		System.out.println(Thread.currentThread().getName()+" Start Time:"+startDate);
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep( 5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" Endaa Time:"+startDate);
	}
	
	
}
