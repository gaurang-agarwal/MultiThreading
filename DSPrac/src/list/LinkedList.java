package list;

public class LinkedList {

	private int size;
	private Node head;
	public LinkedList() {
		size=0;
		head = null;
	}
	
	public int size()
	{
		return size;
	}
	
	public void addNode(Node node)
	{
		if(head == null)
			head = node;
		else
		{
			Node temp = head;
			while(temp.getNext()!=null)
				temp= temp.getNext();
			
			temp.setNext(node);
		}
		size++;
		
	}
	
	public Node addNode(int data)
	{
		Node node = new Node(data);
		addNode(node);
		return node;
	}
	
	public int search(int data)
	{
		int index = 0;
		Node temp = head;
		while(temp!=null)
		{
			if(temp.getData()==data)
				return index;
			index++;
			temp= temp.getNext();
		}
		return -1;
		
	}
	
	public void delete(int data)
	{
		if(head==null)
			return;
		if(head.getData()==data)
		{
			head=head.getNext();
			size--;
		}
		else
		{
			Node temp = head.getNext();
			Node prev=head;
		while(temp!=null)
		{
			if(temp.getData()==data)
			{
				prev.setNext(temp.getNext());
				size--;
				break;
			}
			prev=temp;
			temp=temp.getNext();
		}
		}
		
		
	}
	
	
	public void reverse()
	{
		Node current = head;
		Node prev=head;
		Node rev = null;
		while(current!=null)
		{
			current=current.getNext();
			prev.setNext(rev);
			rev = prev;
			prev=current;
		}
		head=rev;
	}
	
	
	public void reverseInPairs(int n)
	{
		Node current = head;
		Node prev=null;
		Node rev = null;
		head=null;
		Node tail=null;
		while(current!=null)
		{
			Node prevHead = current;
			int counter =0;
			while(current!=null && counter<n)
			{
				prev=current;
				current=current.getNext();
				prev.setNext(rev);
				rev = prev;
				counter++;
			}
			
			prevHead.setNext(current);
			if(head==null)
				head=rev;
			else
			{
				tail.setNext(rev);
			}
			tail = prevHead;
			
		}
		
	}
	
	
	public void reverseRecursively()
	{
		reverse(head);
		
	}
	
	private Node reverse(Node node)
	{
		if(node.getNext()==null)
		{
			head=node;
			return node;
		}
		Node newNode = reverse(node.getNext());
		newNode.setNext(node);
		node.setNext(null);
		return node;
		
	}
	
	
	
	
	
	@Override
	public String toString() 
	{
		StringBuilder returnString = new StringBuilder();
		Node temp = head;
			while(temp!=null)
			{
				returnString.append(temp.getData()).append("->");
				temp= temp.getNext();
			}
		return returnString.toString();
	}
	
}
