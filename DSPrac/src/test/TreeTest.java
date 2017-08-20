package test;

import trees.BinarySearchTree;
import trees.TreeNode;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree tree= getTree();
		/*tree.printPostOrderTraversal();
		tree.printInOrderTraversal();
		tree.printPreOrderTraversal();
		tree.printBreathFirstOrder();
		
		tree.rightRotate(tree.findElement(4));
		
		tree.printPostOrderTraversal();
		tree.printInOrderTraversal();
		tree.printPreOrderTraversal();
		tree.printBreathFirstOrder();
		*/
		
		printBoundry(tree.getRoot());
		
}
	
	private static void printBoundry(TreeNode root)
	{
	
		System.out.println(root.getData());
		printLeft(root.getLeft());
		printLeaf(root);
		printRight(root.getRight());
		
	}
	
	private static void printLeft(TreeNode parentNode)
	{
		if(parentNode==null)
			return;
		
		if(parentNode.getLeft()==null && parentNode.getRight()==null)
			return;
		
		System.out.println(parentNode.getData());
		
		if(parentNode.getLeft()==null)
		{
			printLeft(parentNode.getRight());
		}
		else
		{
			printLeft(parentNode.getLeft());
		}
	}
	
	private static void printRight(TreeNode parentNode)
	{
		if(parentNode==null)
			return;
		
		if(parentNode.getLeft()==null && parentNode.getRight()==null)
			return;
		
		
		if(parentNode.getRight()==null)
		{
			printLeft(parentNode.getLeft());
		}
		else
		{
			printLeft(parentNode.getRight());
		}
		System.out.println(parentNode.getData());
		
	}
	
	private static void printLeaf(TreeNode root)
	{
		
		if(root==null)
			return;
		
		
		if(root.getLeft()==null && root.getRight()==null)
			System.out.println(root.getData());
		
		printLeaf(root.getLeft());
		printLeaf(root.getRight());
	}
	
	/*					5
	 * 				   / \	
	 * 				  4   8
	 *               /    /\
	 * 				2    6  9
	 *             / \    \  \
	 *            1   3    7  10
	 */
	
	private static BinarySearchTree getTree()
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertElement(5);
		tree.insertElement(4);
		tree.insertElement(2);
		tree.insertElement(1);
		tree.insertElement(3);
		tree.insertElement(8);
		tree.insertElement(6);
		tree.insertElement(7);
		tree.insertElement(9);
		tree.insertElement(10);
		return tree;
	}

}



