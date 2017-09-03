package puzzles;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0)
		{
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    
		    Deque<Integer> dQ = new LinkedList<Integer>();
		    int i;
		    for(i=0;i<k;i++)
		    {
		        while(!dQ.isEmpty() && arr[i]>= arr[dQ.peekLast()] )
		        dQ.removeLast();
		        
		        dQ.addLast(i);
		    }
		    for(;i<n;i++)
		    {
		        System.out.print(arr[dQ.peekFirst()]+" ");
		        
		        while(!dQ.isEmpty() && dQ.peekFirst() < i-k )
		        dQ.removeFirst();
		        
		        while(!dQ.isEmpty() && arr[i]>= arr[dQ.peekLast()] )
		        dQ.removeLast();
		        
		        dQ.addLast(i);
		    }
		    System.out.println(arr[dQ.peekFirst()]);
		    
		}
		
	}
}