package pack;

import java.util.LinkedList;

public class TestLinkedList {
	public static Node start;
public static void main(String [] args) {
	start = new Node(1);
	Node pointer =start;
	Node list1=pointer;
	new TestLinkedList().addNode(pointer, 5);
	pointer= pointer.next;
	new TestLinkedList().addNode(pointer, 6);
	pointer= pointer.next;
	Node e=new TestLinkedList().addNode(pointer, 9);
	pointer= pointer.next;
	new TestLinkedList().addNode(pointer, 10);
	pointer= pointer.next;
	new TestLinkedList().addNode(pointer, 13);
	pointer= pointer.next;
	
	new TestLinkedList().addNode(pointer, 15);
	pointer= pointer.next;
	
	new TestLinkedList().addNode(pointer, 17);
	pointer= pointer.next;
	new TestLinkedList().addNode(pointer, 19);
	pointer= pointer.next;
	/*new TestLinkedList().addSorted(12, pointer);
	
	pointer=start;
	new TestLinkedList().addSorted(17, pointer);
	
	pointer=start;
	new TestLinkedList().addSorted(0, pointer);
	
	pointer=start;
	new TestLinkedList().addSorted(2, pointer);
	
	pointer=start;
	new TestLinkedList().addSorted(115, pointer);
	
	pointer=start;
	new TestLinkedList().addSorted(105, pointer);
	
	pointer=start;
	new TestLinkedList().addSorted(100, pointer);
	*/
	
	System.out.println("List 1::"+start);
	pointer=new Node(80);
	Node list2=pointer;
	new TestLinkedList().addNode(pointer, 90);
	pointer=pointer.next;
	new TestLinkedList().addNode(pointer, 100);
	pointer=pointer.next;
	new TestLinkedList().addNode(pointer, 110);
	pointer=pointer.next;
	
	new TestLinkedList().addNode(pointer, 105);
	pointer=pointer.next;
	
	new TestLinkedList().addNode(pointer, 106);
	pointer=pointer.next;
	
	System.out.println("List 2::"+list2);
	deleteAlternateNode();
//	mergeListAlternate(list1, list2);
	
	//Node loopHead=new TestLinkedList().addNode(pointer, 120);
	//pointer=pointer.next;
	//loopHead.next=e;
	//System.out.println(">>>>>>>Loop Head Hard Code:"+e);
	//loopExists(pointer=start);
	//pointer=start;
	//reverseEveryKNode(pointer, 2);
	//printList();
	
}

public static void deleteAlternateNode(){
	Node head=start;
	printList();
	Node result=head;
	while(head!=null && head.next!=null){
		head.next=head.next.next;
		if(head==null)
			break;
		head=head.next;
	}
	
	start=result;
	printList();
	
	
}



public static void mergeListAlternate(Node list1,Node list2){
	Node resultList=list1;
	while(list1!=null && list2!=null){
		Node q=list1.next;
		Node p= list2.next;
		list1.next=list2;
		
		
		
		list1=list1.next;
	}
	start=resultList;
	printList();
}



public static void mergeList(Node list1,Node list2){
	Node first=list1.next;
	Node second=list2;
	Node resultList= list1;
	Node start=resultList;
	int counter=1;
	while(first!=null && second!=null){
		if(counter%2==0){
			resultList.next=first;
			first=first.next;
		}
		else{
			resultList.next=second;
			second=second.next;
		}
		resultList=resultList.next;
		counter++;
		
	}
	printList();
			
	
}

public static void reverseEveryKNode(Node pointer,int k){
	Node p=pointer;
	Node q=pointer;
	Node r=null;
	//printList();
	while(q!=null)
	{
		
		r=null;
		int counter=0;
		while(q!=null && counter<k){
			q=q.next;
			p.next=r;
			r=p;
			p=q;
			counter++;
			System.out.println("Counter::"+counter);
		}
		r.next.next=p;
		System.out.println("head:"+q);
		start=r;
		System.out.println("**");
		printList();
		
	}
	
}

private static void loopExists(Node head){
	Node slowPointer=head;
	Node fastPointer=head.next;
	while(fastPointer!=null && fastPointer.next!=null&& slowPointer!=fastPointer){
		fastPointer=fastPointer.next.next;
		slowPointer=slowPointer.next;
		
	}
	System.out.println(">>>slowPointer>>"+slowPointer);
	System.out.println(">>>fastPointer>>"+fastPointer);
	if(slowPointer!=null && slowPointer==fastPointer){
		System.out.println("Loop Exists");
		int loopLength=1;
		slowPointer=slowPointer.next;
		while(slowPointer!=fastPointer){
			slowPointer=slowPointer.next;
			loopLength++;
		}
		System.out.println("Loop Length::::"+loopLength);
		slowPointer=head;
		fastPointer=head;
		for(int i=1;i<loopLength;i++)
			fastPointer=fastPointer.next;
		while(fastPointer.next!=slowPointer){
			fastPointer=fastPointer.next;
			slowPointer=slowPointer.next;
		}
		System.out.println("fast:"+fastPointer);
		System.out.println("slow:"+slowPointer);
		fastPointer.next=null;
		printList();
		
	}
	else{
		System.out.println("Loop no Exists");
	}
	
	
	
}


private static Node reverse(Node head) {
if (head == null || head.next == null) return head;
Node tail = head.next;
head.next = null;
Node reversed = reverse(tail);
tail.next = head;
return reversed;
}

public static void deleteMN(int m,int n)
{
	System.out.println("*******************************DeleteMN*****************");
	Node temp=null;
	Node beforeStart= new Node(-1);
	beforeStart.next=start;
	Node current = beforeStart;
	Node q;
	while(current!=null)
	{
		int i=0;
		int j=0;
		while(i<m && current!=null)
		{
			current=current.next;
			i++;
		}
		if(current==null){
			break;
		}
		q=current;
		while(j<n && q.next!=null)
		{
			q=q.next;
			j++;
		}
		current.next=q.next;
	}
	printList();
}
static Node newStart=new Node(1);
public static Node recursiveReverse(Node begin){
	if(begin.next!=null){
		System.out.println("returning for : "+newStart.next);
		return newStart.next=recursiveReverse(begin.next);
	}
	
	System.out.println("begin:"+newStart);
	System.out.println(">"+newStart);
	return newStart;
	
}


public static void reverseList()
{
	Node p=start;
	Node r=null;
	Node q=start;
	while(q!=null){
		q=q.next;
		p.next=r;
		r=p;
		p=q;
	}
	start=r;
	printList();
}


public void addSorted (Integer value,Node pointer)
{
	if(value<pointer.value){
		start=new Node(value,pointer);
		return;
	}
	
	while(pointer.next!=null && pointer.next.value < value)
	{
		pointer=pointer.next;
	}
		pointer.next=new Node(value,pointer.next);
}

public void removeSort(Integer data,Node list){
	if(data==start.value){
		start=start.next;
	}
	Node head=list;
	while(head.next.value!=data && head.next.next!=null ){
		head=head.next;
	}
	if(head.next.value==data)
	{
		head.next=head.next.next;
	}
	
}


public static void rightRotate(int n){
	Node p=start;
	Node np=start;
	int i=0;
	while(i<n){
		np=np.next;
	i++;
	}
	while(np.next!=null)
	{
		p=p.next;
		np=np.next;
	}

	np.next=start;
	start=p.next;
	p.next=null;
	printList();
}

public static void leftRotate(int n){
	Node p=start;
	Node np=start;
	int i=1;
	while(i<n){
		np=np.next;
	i++;
	}
	start=np.next;
	while(np.next!=null)
	{
		np=np.next;
	}

	np.next=p;
	i=1;
	while(i<n){
		p=p.next;
	i++;
	}
	
	p.next=null;
	printList();
}


public Node addNode(Node list, Integer value)
{
	Node q=new Node(value);
	list.next=q;
	return q;
}


public static void printList(){
	Node p=start;
	if(p==null){
		System.out.println("***********Empty List**************");
	return;
	}
	while(p.next!=null){
		 System.out.print("|"+p.value+"|->");
		 p=p.next;
	 }
	 System.out.println("|"+p.value+"|");
}

}


