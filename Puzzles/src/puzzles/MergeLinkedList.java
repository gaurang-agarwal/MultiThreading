package puzzles;

import list.LinkedList;
import list.Node;

public class MergeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list1 = new LinkedList();
		list1.addNode(1);
		list1.addNode(3);
		list1.addNode(5);
		list1.addNode(7);
		list1.addNode(9);
		list1.addNode(11);
		
		LinkedList list2 = new  LinkedList();
		list2.addNode(2);
		list2.addNode(4);
		list2.addNode(6);
		list2.addNode(8);
		
		
		Node pCurr = list1.getHead();
		Node qCurr = list2.getHead();
		Node pNext=null,qNext=null;
		while(pCurr!=null && qCurr!=null)
		{
			pNext=pCurr.getNext();
			qNext=qCurr.getNext();	
			pCurr.setNext(qCurr);
			qCurr.setNext(pNext);
			
			pCurr=pNext;
			qCurr=qNext;
		}
		System.out.println(list1);
		
	}

}
