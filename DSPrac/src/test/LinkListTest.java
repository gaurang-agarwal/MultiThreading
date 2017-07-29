package test;

import list.LinkedList;

public class LinkListTest {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addNode(0);
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.addNode(8);
		list.addNode(9);
		System.out.println(list);
		list.reverseInPairs(3);
		System.out.println(list);
		
		
	}

}
