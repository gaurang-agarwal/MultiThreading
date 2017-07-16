package trees;


public class AVLTree extends BinarySearchTree {

	@Override
	public TreeNode insertElement(int data) {
		TreeNode root = getRoot();
		if(root==null)
			return insertElement(null, data, null);
		
		TreeNode parent = null;
		while(root!=null)
		{
			parent = root;
			if(data<root.getData())
				root = root.getLeft();
			else
					root = root.getRight();
			
		}
		
		TreeNode insertedNode = super.insertElement(parent, data, data<=parent.getData()?POSITION.LEFT:POSITION.RIGHT);
		avlTreeFixup(insertedNode);
		return insertedNode;
	
	}
	
	private void avlTreeFixup(TreeNode insertedNode)
	{
		TreeNode temp = insertedNode.getParent();
		boolean isFixupRequired = false;
		int leftHeight =0;
		int rightHeight = 0;
		while(temp!=null)
		{
			leftHeight = getHeight(temp.getLeft());
			rightHeight = getHeight(temp.getRight());
			if(Math.abs(leftHeight-rightHeight) >1)
					{
							isFixupRequired = true;
							break;
					}
			temp=temp.getParent();
		}
		
		if(isFixupRequired)
		{
			
		}
		
		
		
	}
	
	public int getHeight(TreeNode node)
	{
		if(node==null)
			return 0;
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight()))+1;
	}
	
	
}
