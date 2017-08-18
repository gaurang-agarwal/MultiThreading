package puzzles;

import java.util.PriorityQueue;

public class MergeKSortedArrayUsingPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] arr = new int[][] {
			{8,9,10,12},
			{2,5,9,12},
			{3,6,10,11},
			{1,4,7,8}
		};		
		
		PriorityQueue<HeapNode> heap = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++)
		{
			heap.offer(new HeapNode(arr[i][0], i, 0));
		}
		int count=0;
		while(count<16)
		{
			HeapNode min = heap.poll();
			System.out.println(min.value);
			count++;
			int value=0;
			int nextIndex=min.index+1;
			if(nextIndex < arr[min.k].length)
			{
				
				value=arr[min.k][nextIndex];
			}
			else
			{
				value=Integer.MAX_VALUE;
			}
			heap.offer(new HeapNode(value, min.k, nextIndex));
			
		}
		
		
		
	}

	
	static class HeapNode implements Comparable<HeapNode>
	{
		 int value,k,index;
		public HeapNode(int value,int k,int index) 
		{
			this.index=index;
			this.k=k;
			this.value=value;
		}
		
		@Override
		public int compareTo(HeapNode o) {
			// TODO Auto-generated method stub
			return new Integer(value).compareTo(o.value);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return value+":"+k+":"+index;
		}
	}
	
}
