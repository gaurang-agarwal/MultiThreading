package test;

import trees.BinarySearchTree;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree tree= getTree();
		tree.printPostOrderTraversal();
		tree.printInOrderTraversal();
		tree.printPreOrderTraversal();
		tree.printBreathFirstOrder();
		
		tree.rightRotate(tree.findElement(4));
		
		tree.printPostOrderTraversal();
		tree.printInOrderTraversal();
		tree.printPreOrderTraversal();
		tree.printBreathFirstOrder();
		
		
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



