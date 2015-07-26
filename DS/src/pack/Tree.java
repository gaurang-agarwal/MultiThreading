package pack;

public class Tree {
	
	public TreeNode root;
	public Tree(TreeNode root) {
		this.root = root;
	}

	public Tree() {
	}
	
	public TreeNode setLeftChild(TreeNode parent,TreeNode child){
		child.parent=parent;
		parent.left=child;
		return child;
	}
	
	public TreeNode setRightChild(TreeNode parent,TreeNode child){
		child.parent=parent;
		parent.right=child;
		return child;
	}
	
	public TreeNode getRightChild(TreeNode parent){
		return parent.right;
	}
	
	public TreeNode getLeftChild(TreeNode parent){
		return parent.left;
	}
	
	public TreeNode getRoot() {
		return this.root;
	}

	public void setRoot(TreeNode root) {
		root.parent=null;
		this.root = root;
	}


	static class TreeNode {
		
		final Integer value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		public TreeNode(Integer value) {
			this.value = value;
		}

		
		

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			
			return value.toString();
		}
		
	}
}
