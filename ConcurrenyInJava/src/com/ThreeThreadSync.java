package com;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class ThreeThreadSync {

private int conter =0;

public int getCounter()
{
        return conter;
}

public void incrementCounter()
{
        this.conter++;
}

        public static void main(String[] args) throws InterruptedException {
                // TODO Auto-generated method stub
                final char[] source = "ABCDEF".toCharArray();
                
                final ThreeThreadSync sync = new ThreeThreadSync();
                
                Thread t1 = new Thread(new Task(source, sync, 0),"One");
                Thread t2 = new Thread(new Task(source, sync, 1),"Two");
                Thread t3 = new Thread(new Task(source, sync, 2),"Three");
                
                t1.start();
                t2.start();
                t3.start();
                
                

        }
        
        
        
        

}


class Task implements Runnable{

        char[] source = null;
        int posision;
        ThreeThreadSync sync=null;
        public Task(char[]source,ThreeThreadSync sync,int position) {
                // TODO Auto-generated constructor stub
                this.source=source;
                this.sync=sync;
                this.posision=position;
        }
        
        @Override
        public void run() {
                // TODO Auto-generated method stub
                try {
                        synchronized (sync) {
                                while(sync.getCounter()<source.length)
                                {        
                                        System.out.println(Thread.currentThread().getName()+"---" +sync.getCounter());
                                while(!(sync.getCounter()%3==posision))
                                {
                                        sync.wait();
                                }
                                if(sync.getCounter()<source.length)
                                        System.out.println(Thread.currentThread().getName()+"-" +source[sync.getCounter()]);
                                sync.incrementCounter();
                                sync.notifyAll();
                                }
                                }
                        
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }
        
}
        