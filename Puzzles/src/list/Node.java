package list;

public class Node 
{
	private int data;
	private Node next;
	
	public Node(int data) {
	this.data=data;
	}
	
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(data); 
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(obj!=null && obj instanceof Node)
		{
			Node o = (Node)obj;
			return this.getData()==o.getData();
		}
		return false;
	}
}
