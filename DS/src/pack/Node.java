package pack;

public class Node implements Comparable<Node>{
	Integer value = null;
Node next=null;
	public Node(Integer value){
	this.value=value;
}
	public Node(Integer value,Node next){
	this.value=value;
	this.next=next;
}	
	
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
		
		
			return this.value.toString();
		}
	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return this.value.compareTo(node.value);
	}	
}
