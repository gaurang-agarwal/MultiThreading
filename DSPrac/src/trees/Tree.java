package trees;

public class Tree {
	
	public static enum POSITION {LEFT,RIGHT;
	@Override
	public String toString()
	{
		if(this == LEFT)
			return "LEFT";
		return "RIGHT";
	}
	};
	
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode insertElement(TreeNode parent,int data,POSITION position)
	{
		TreeNode node = new TreeNode(data);
		if(root==null)
		{
			root = node;
		}
		else if(POSITION.LEFT.equals(position))
		{
			parent.setLeft(node);
		}
		else
		{
			parent.setRight(node);
		}
		node.setParent(parent);
		return node;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		printTree(string, root);
		return string.toString();
	}
	
	protected void printTree(StringBuilder string,TreeNode node)
	{
			if(node.getLeft()!=null)
			{
				printTree(string, node.getLeft());
			}
			
			string.append(node).append("->");
			
			if(node.getRight()!=null)
			{
				printTree(string, node.getRight());
			}
	}
}
