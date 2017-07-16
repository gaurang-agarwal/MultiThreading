package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree extends Tree {

	
	
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
		return super.insertElement(parent, data, data<=parent.getData()?POSITION.LEFT:POSITION.RIGHT);
	}
	
	
	public void printInOrderTraversal()
	{
		System.out.println(super.toString());
	}
	
	public void printPostOrderTraversal()
	{
		postOrderTraversal(getRoot());
		System.out.println();
	}
	
	private void postOrderTraversal(TreeNode node)
	{
		if(node.getLeft()!=null)
		{
			postOrderTraversal(node.getLeft());
		}
		if(node.getRight()!=null)
		{
			postOrderTraversal(node.getRight());
		}
		System.out.print(node+"->");
		
	}
	
	
	public void printPreOrderTraversal()
	{
		preOrderTraversal(getRoot());
		System.out.println();
	}
	
	private void preOrderTraversal(TreeNode node)
	{
		System.out.print(node+"->");
		if(node.getLeft()!=null)
		{
			preOrderTraversal(node.getLeft());
		}
		if(node.getRight()!=null)
		{
			preOrderTraversal(node.getRight());
		}
		
	}
	
	public TreeNode findElement(int data)
	{
		TreeNode root = getRoot();
		
		while(root!=null)
		{
			if(data == root.getData())
			{
				return root;
			}
			if(data<root.getData())
				root = root.getLeft();
			else
					root = root.getRight();
			
		}
		
			return null;		
		
	}
	
	
	public TreeNode getTreeMin()
	{
		return getSubTreeMin(getRoot());
	}
	
	public TreeNode getSubTreeMin(TreeNode node)
	{
		if(node == null)
			return null;
		
		while(node.getLeft()!=null )
			node = node.getLeft();
		return node;
	}
	
	public TreeNode getSubTreeMax(TreeNode node)
	{
		if(node == null)
			return null;
		while(node.getRight()!=null )
			node = node.getRight();
		return node;
	}
	
	public TreeNode getSuccessor(int n)
	{
		TreeNode node = findElement(n);
		if(node.getRight()!=null)
			return getSubTreeMin(node.getRight());
		
		TreeNode p = node.getParent();
		while(p!=null && node.getParent().getRight() ==node)
		{
			node=p;
			p = node.getParent();
			
			
		}
		
		return p;
	}
	
	public TreeNode getPredecessor(int data)
	{
		TreeNode node = findElement(data);
		if(node.getLeft()!=null)
			return getSubTreeMax(node.getLeft());
		
		if(node.getParent()==null)
			return null;
		
		TreeNode p = node.getParent();
		while(p!=null && p.getLeft() ==node)
		{
			node=p;
			p = node.getParent();
			
			
		}
		
		return p;
		
		
	}
	
	public void delete(int data)
	{
		TreeNode node = findElement(data);
		if(node.getLeft()==null)
			 transplant(node, node.getRight());
		
		if(node.getRight()==null)
			 transplant(node, node.getLeft());
		
		TreeNode successor = getSuccessor(data);
		if(node.getRight()!=successor)
		{
			transplant(successor, successor.getRight());
			successor.setRight(node.getRight());
			successor.getRight().setParent(successor);
		}
		transplant(node, successor);
		successor.setLeft(node.getLeft());
		successor.getLeft().setParent(successor);
		
		if(node==getRoot())
			setRoot(successor);
	}
	
	private void transplant(TreeNode oldNode,TreeNode newNode)
	{
		if(oldNode.getParent()!=null)
		{
			if(oldNode.getParent().getRight()==oldNode)
				oldNode.getParent().setRight(newNode);
			
			if(oldNode.getParent().getLeft()==oldNode)
				oldNode.getParent().setLeft(newNode);
		}
		if(newNode!=null){
			newNode.setParent(oldNode.getParent());
		}
		
	}
	
	public void printBreathFirstOrder()
	{
		TreeNode root = getRoot();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode temp = q.poll();
			System.out.print(temp);
			if(temp.getLeft()!=null)
				q.add(temp.getLeft());
			if(temp.getRight()!=null)
					q.add(temp.getRight());
		}
		System.out.println();
	}
	
	
	public void rightRotate(TreeNode about)
	{
		TreeNode y = about.getLeft();
		TreeNode temp = y.getRight();
		if(about.getParent().getLeft()==about)
		{
			about.getParent().setLeft(y);
		}
		else 
		{
			about.getParent().setRight(y);
		}
		y.setParent(about.getParent());
		y.setRight(about);
		about.setParent(y);
		temp.setParent(about);
		about.setLeft(temp);
	}
}
