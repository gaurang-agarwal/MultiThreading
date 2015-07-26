package pack;


import pack.Tree.TreeNode;

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode rootNode= new TreeNode(20);
		Tree tree = new Tree(rootNode);
		TreeNode node23=new BinarySearchTree().insertNode(10,tree);
		new BinarySearchTree().insertNode(15,tree);
		new BinarySearchTree().insertNode(50,tree);
		new BinarySearchTree().insertNode(12,tree);
		new BinarySearchTree().insertNode(23,tree);
		new BinarySearchTree().insertNode(1,tree);
		new BinarySearchTree().insertNode(100,tree);
		new BinarySearchTree().insertNode(18,tree);
		new BinarySearchTree().insertNode(16,tree);
		new BinarySearchTree().insertNode(13,tree);
		printTree(tree.getRoot());
		System.out.println();
		printPostOrderTree(tree.getRoot());
		System.out.println("\nTree Min is:"+new BinarySearchTree().treeMin(tree.getRoot()));
		System.out.println("Tree Max is:"+new BinarySearchTree().treeMax(tree.getRoot()));
		System.out.println("Sucessor of "+node23+" is "+new BinarySearchTree().getSuccessor(node23));
		System.out.println("Predecessor of "+node23+" is "+new BinarySearchTree().getPredecessor(node23));
		new BinarySearchTree().deleteNode(tree, node23);
		System.out.println("After Deleting "+node23+"\n");
		printTree(tree.getRoot());
		
	}
	
	
	public TreeNode insertNode(TreeNode newNode,Tree tree){
		
		TreeNode root=tree.getRoot();
		if(root ==null){
			tree.setRoot(newNode);
			return tree.getRoot();
		}
		
		TreeNode y=root;
		TreeNode x=null;
		while(root!=null)
		{
			x=root;
			if(newNode.value<root.value){
				root=root.left;
			}
			else {
				root=root.right;	
			}
		}
		if(newNode.value<x.value)
		{	
			return tree.setLeftChild(x, newNode);
		}
		else{
			return tree.setRightChild(x, newNode);
		}
		
	}
	
	
	public TreeNode insertNode(Integer value,Tree tree){
		TreeNode newNode= new TreeNode(value);
		return insertNode(newNode, tree);
	}
	
	public static void printTree(TreeNode root){
		
		
		if(root!=null){
			
			printTree(root.left);
			System.out.print(root+">");
			printTree(root.right);
		}
		
	}
	

	public static void printPostOrderTree(TreeNode root){
		
		
		if(root!=null){
			printPostOrderTree(root.right);
			System.out.print(root+">");
			printPostOrderTree(root.left);
		}
		
	}
	
	
	public TreeNode treeMin(TreeNode root){
		while(root.left!=null){
			root=root.left;
		}
		return root;
	}
	public TreeNode treeMax(TreeNode root){
		while(root.right!=null){
			root=root.right;
		}
		return root;
	}
	
	public TreeNode getSuccessor(TreeNode node){
		if(node.right!=null){
			return treeMin(node.right);
		}
		TreeNode y=node.parent;
		while(y!=null && y.right==node)
		{
			node=y;
			y=y.parent;
		}
		return y;
	}
	
	public TreeNode getPredecessor(TreeNode node){
		if(node.left!=null){
			return treeMax(node.left);
		}
		if(node.parent==null){
			return null;
		}
		if(node.parent.right==node){
			return node.parent;
		}
		TreeNode y=node.parent;
		System.out.println(">>>>>>>>>>>"+y);
		while(y!=null && y.parent!=null && y.parent.right==y)
		{
			y=y.parent;
		}
		return y;
	}	
	
	

	public void  deleteNode(Tree tree,TreeNode node){
		if(node.left==null){
			transplant(tree, node, node.right);
			
		}
		else if(node.right==null){
			transplant(tree, node, node.left);
		}
		else {
			TreeNode y=getSuccessor(node);
			if(y.parent!=node){
				transplant(tree, y, y.right);
				y.right=node.right;
				y.right.parent=node;
			}
			transplant(tree, node, y);
			y.left=node.left;
			y.left.parent=y;
		}
		
		
		
	}

	public void transplant(Tree tree, TreeNode u,TreeNode v)
	{
		if(u.parent==null)
			tree.setRoot(v);
		else if(u.parent.left==u)
		{
			u.parent.left=v;
		}
		else if(u.parent.right==u)
		{
			u.parent.right=v;
		}
		if(v!=null)
		v.parent=u.parent;
		
	}
	
	
	
}
