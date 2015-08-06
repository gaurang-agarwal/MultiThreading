package com;

public class Calculator {

	public static void main(String args[]){
		Thread [] thread  = {new Thread(new Table(1)," One ") ,new Thread(new Table(2)," Two "),new Thread(new Table(3)," Three "),new Thread(new Table(4)," Four "),new Thread(new Table(5)," Five "),new Thread(new Table(6)," Six "),new Thread(new Table(7)," Seven "),new Thread(new Table(8)," Eight "),new Thread(new Table(9)," Nine "),new Thread(new Table(10)," Ten ")};
		Thread.State threadState[]= new Thread.State[10];
		
		for(int i=0;i<10;i++){
			if(i%2==0){
				thread[i].setPriority(Thread.MAX_PRIORITY);
			}
			else {
				thread[i].setPriority(Thread.MIN_PRIORITY);
				}
		}
		for(int i=0;i<10;i++){
			System.out.println("State of "+thread[i].getName()+" : "+thread[i].getState());
			threadState[i]=thread[i].getState();
		}
		for(int i=0;i<10;i++){
			thread[i].start();
		}
		boolean finish=false;
		while (!finish) {
		for (int i=0; i<10; i++){
		if (thread[i].getState()!=threadState[i]) {
			System.out.println("Main : Id "+thread[i].getId() +" "+thread[i].getName());
			System.out.println("Main : Priority: "+thread[i].getPriority());
			System.out.println("Main : Old State: "+threadState[i]);
			System.out.println("Main : New State: "+thread[i].getState());
			System.out.println("Main : ************************************\n");
			threadState[i]=thread[i].getState();
		}
		}
		finish=true;
		for (int i=0; i<10; i++){
		finish=finish &&(thread[i].getState()==Thread.State.TERMINATED);
		}
		}
	}
	
	
	
	
}



class Table implements Runnable {
private int number;
	public Table(int number) {
	// TODO Auto-generated constructor stub
		this.number=number;
	
}


@Override
public void run() {
	// TODO Auto-generated method stub
for(int i=1;i<=10;i++){
	System.out.println("Thread : "+Thread.currentThread().getName()+" "+number+" x "+i+" = "+(number*i));
}
}
	
	
}