package puzzles;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianForStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> lower = new PriorityQueue<>((o1,o2)-> { return -1*(o1.compareTo(o2));}); //Max Heap
		Queue<Integer> higher = new PriorityQueue<>();//Min Heap
		for(int i : new int[]{5, 15, 1, 3})
		{
			addElementToHeap(lower, higher, i);
		if(lower.size()==higher.size())
			System.out.println((lower.peek()+higher.peek())/2);
		else if(lower.size() > higher.size())
			System.out.println(lower.peek());
		else 
			System.out.println(higher.peek());
		}
		
		
	}

	private static void addElementToHeap(Queue<Integer> lower,Queue<Integer> higher,int element)
	{
		if(lower.size()==0 || lower.peek() < element)
		{
			lower.add(element);
		}
		else
		{
			higher.add(element);
		}
		
		balance(lower,higher);
		
	}

	private static void balance(Queue<Integer> lower, Queue<Integer> higher) 
	{
		if(lower.size() - higher.size()>1)
		{
			higher.offer(lower.poll());
		}
		else if(higher.size() - lower.size()>1)
		{
			lower.offer(higher.poll());
		}
	}
	
	
}
