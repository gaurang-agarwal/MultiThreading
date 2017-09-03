package puzzles;

import list.LinkedList;
import list.Node;

public class AddTwoNumbersByLinkedList {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list1 = new LinkedList();
		list1.addNode(5);
		list1.addNode(6);
		list1.addNode(5);
		list1.addNode(5);
		
		
		LinkedList list2 = new LinkedList();
		list2.addNode(7);
		list2.addNode(9);
		Node node1=list1.getHead();
		Node node2=list2.getHead();
		
		LinkedList resultList = new LinkedList();
		int carry=0;
		while(node1!=null || node2!=null)
		{
			
			int sum = carry + (node1!=null?node1.getData():0)+(node2!=null?node2.getData():0);
			
			carry = sum/10;
			resultList.addNode(sum%10);
			
			if(node1!=null)
				node1=node1.getNext();
			
			if(node2!=null)
				node2=node2.getNext();
		}
		
		if(carry!=0)
		resultList.addNode(carry);
		list1.reverse();
		list2.reverse();
		resultList.reverse();
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(resultList);
	}
	

}
