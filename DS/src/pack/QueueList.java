package pack;

import pack.Tree.TreeNode;

public class QueueList {
	private QNode head;
	private QNode tail;
	public QueueList() {
		// TODO Auto-generated constructor stub
	}
	
	public QueueList(QNode head) {
		// TODO Auto-generated constructor stub
		this.head=head;
		this.tail=head;
	}
	
	public QNode getHead(){
		return head;
	}
	public QNode getTail() {
		return tail;
	}

	public void insert(QNode node) 
	{
		if(head==null || tail==null)
		{
			head=node;
			tail=node;
		}
		else 
		{
			tail.next=node;
			tail=tail.next;
		}
	}
	
	
	public QNode remove(){
		QNode oldead= new QNode(head.data);
		oldead.next=head.next;
		head=head.next;
		return oldead;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("\n**************Queue**************\n");
		StringBuilder qString= new StringBuilder();
		QNode q=this.head;
		while(q.next!=null)
		{
			qString.append("|").append(q).append("|>");
			q=q.next;
		}
		
		
		return qString.toString();
	}


	static class QNode extends Node{
		Integer data;
		QNode next;
		public QNode() {
			super(null);
			// TODO Auto-generated constructor stub
		}
		public QNode(Integer data) {
			super(data);
			// TODO Auto-generated constructor stub
			this.data=data;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}
		
		
	}
}
