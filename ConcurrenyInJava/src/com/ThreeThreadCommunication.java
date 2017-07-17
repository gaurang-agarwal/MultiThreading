package com;

public class ThreeThreadCommunication {

	int counter=1;
	public static void main(String[] args) {

		
		ThreeThreadCommunication tc = new ThreeThreadCommunication();
		new Thread(new Task(tc, 0)).start();
		new Thread(new Task(tc, 1)).start();
		new Thread(new Task(tc, 2)).start();
		
	}

	
	private static class Task implements Runnable
	{
		ThreeThreadCommunication tc;
		int n;
		Task(ThreeThreadCommunication tc,int n)
		{
			this.tc=tc;
			this.n=n;
			
		}
		@Override
		public void run() {
	
			try {
				synchronized (tc) {
			while(tc.counter<=15)
			{
					while(tc.counter%3!=n)
					{
						tc.wait();
					}
					
					System.out.println(Thread.currentThread().getName()+"->"+tc.counter);
					tc.counter++;
					tc.notifyAll();
					Thread.sleep(1000);
			}
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
			
		}
		
	}
	
}
