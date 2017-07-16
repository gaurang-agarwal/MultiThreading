package trees;

public class TreeNode {
	
	
	private int data;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	
	public TreeNode(int data) {
		this.data=data;
	}	
	public int getData() {
		return data;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+data+"]";
		//return "{data:"+data+",Parent:"+(parent!=null?parent.getData():null)+"}";
	}
	
	public static TreeNode copyNode(TreeNode node)
	{
		TreeNode copy = new TreeNode(node.data);
		copy.setLeft(node.getLeft());
		copy.setRight(node.getRight());
		copy.setParent(node.getParent());
		return copy;
	}
	
	@Override
	public boolean equals(Object obj) {
			if(obj==null) return false;		
		return this.data == ((TreeNode)obj).getData();
	}
}
