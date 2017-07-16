package trees;

public class RBTreeNode extends TreeNode {
	
	public RBTreeNode(int data) {
		this(data,COLOR.BLACK);
		// TODO Auto-generated constructor stub
	}
	public static enum COLOR {RED,BLACK};
	private COLOR color;
	public RBTreeNode(int data,COLOR color) 
	{
		super(data);
		this.color=color;
	}

	
	
	public COLOR getColor() {
		return color;
	}



	public void setColor(COLOR color) {
		this.color = color;
	}



	public boolean isLeafNode()
	{
		return this.getLeft()==null && this.getRight()==null && this.getColor()==COLOR.BLACK;
	}
	
}
