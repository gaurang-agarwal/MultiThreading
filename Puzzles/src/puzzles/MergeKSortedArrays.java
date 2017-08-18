package puzzles;

import java.util.Arrays;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] arr = new int[][] {
			{8,9,10,12},
			{2,5,9,12},
			{3,6,10,11},
			{1,4,7,8}
		};
		int k =arr.length;
		HeapNode [] heap = new HeapNode[k];
		for(int i=0;i<k;i++)
		{
			heapInsert(new HeapNode(arr[i][0], i, 0), heap, i);
		}
		int count=0;
		while(count!=16)
		{
			HeapNode min = extractMin(heap);
			System.out.print(min.value+" ");
			if(min.index  < arr[min.k].length-1)
			{
				min.index++;
				min.value=arr[min.k][min.index];
			}
			else
			{
				min.value=Integer.MAX_VALUE;
			}
			moveDown(heap, 0, heap.length);
			count++;
		}
		
	}

	static void heapInsert(HeapNode node,HeapNode []arr,int k)
	{
		arr[k] = node;
		int parent =(k-1)/2;
		if(k>0 && arr[parent].compareTo(arr[k])>0)
		{
			HeapNode temp = arr[parent];
			arr[parent]=arr[k];
			arr[k]=temp;
			heapInsert(node, arr, parent);
		}
		
	}
	
	static HeapNode extractMin(HeapNode arr[])
	{
		
		return arr[0];
	}
	static void moveDown(HeapNode arr[],int pos,int size)
	{
		int left= pos*2+1;
		int right = pos*2+2;
		int min =pos;
		if(left<size && arr[left].compareTo(arr[min])<0)
		{
			min =left;
		}
		if(right<size && arr[right].compareTo(arr[min])<0 )
		{
			min =right;
		}
		if(min!=pos)
		{
			HeapNode temp = arr[min];
			arr[min]=arr[pos];
			arr[pos]=temp;
			moveDown(arr, min, size);
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
