package puzzles;

import java.util.Deque;
import java.util.LinkedList;
/*
 * We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements.
 *  An element is useful if it is in current window and is greater than all other elements on left side 
 *  of it in current window. 
 *  We process all array elements one by one and maintain Qi to contain useful elements of current window 
 *  and these useful elements are maintained in sorted order. 
 *  The element at front of the Qi is the largest and element at rear of Qi is the smallest of current window. 
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr [] = {12, 1, 78, 90, 57, 89, 56};
		int k =3;
		Deque<Integer> dQ = new LinkedList<>();
		int i;
		for(i=0;i<k;i++)
		{
			while(!dQ.isEmpty() && arr[i]>=arr[dQ.peekLast()] )
			{
				dQ.removeLast();
			}
			dQ.addLast(i);
		}
		
		while(i <arr.length)
		{
			System.out.print(arr[dQ.peekFirst()]+" ");
			
			while(!dQ.isEmpty() && dQ.peekFirst() <= i-k)
				dQ.removeFirst();
			
			while(!dQ.isEmpty() && arr[i]>=arr[dQ.peekLast()] )
			{
				dQ.removeLast();
			}
			dQ.addLast(i);
			i++;
		}
		System.out.println(arr[dQ.peek()]);
		
	}

}
