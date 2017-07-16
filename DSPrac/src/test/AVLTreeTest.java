package test;

import trees.AVLTree;

public class AVLTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AVLTree tree= getTree();
		tree.printInOrderTraversal();
		
		
		
}
	/*					5
	 * 				   / \	
	 * 				  4   8
	 *               /    /\
	 * 				2    6  9
	 *             / \    \  \
	 *            1   3    7  10
	 */
	
	private static AVLTree getTree()
	{
		AVLTree tree = new AVLTree();
		tree.insertElement(5);
		tree.insertElement(8);
		tree.insertElement(4);
		tree.insertElement(2);
		tree.insertElement(1);
		tree.insertElement(3);
		tree.insertElement(6);
		tree.insertElement(7);
		tree.insertElement(9);
		tree.insertElement(10);
		tree.insertElement(11);
		return tree;
	}

}



