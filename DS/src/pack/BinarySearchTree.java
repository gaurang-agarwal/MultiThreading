package pack;


import java.util.Arrays;

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
		printTree(tree.getRoot());
		TreeNode [] q= new TreeNode[20];
		int head=0;
		int tail=1;
		q[0]=tree.getRoot();
		System.out.println("\n**************BFS**************");
		BFS(q, head, tail);
		System.out.println("\n**************All Path SUm**************");
		allPathSumDFS(tree.getRoot(), 0);
		
		System.out.println("\n");
		spiralOrder(tree.getRoot());
		System.out.println("Print Range starts");
		new BinarySearchTree().printRangeNodes(tree.getRoot(), 14, 50);
		System.out.println("Print Range ends");
		
		
		System.out.println("\n>>Sorted<<<");
		BinarySearchTree forPrint=new BinarySearchTree();
		forPrint.node=getLinkedList();
		Tree newTree = new Tree(forPrint.sortedListToBST(0,8));
		printTree(newTree.getRoot());
		forPrint=new BinarySearchTree();
		forPrint.node=getLinkedList();
		q[0]=forPrint.sortedListToBST(0,8);
		System.out.println("\n>>BFS<<<");
		BFS(q, head, tail);
		
		forPrint=new BinarySearchTree();
		forPrint.node=getLinkedList();
		spiralOrder(forPrint.sortedListToBST(0,8));
		
	}
	
	
	public static void allPathSumDFS(TreeNode root,int sum){
		if(root!=null){
			sum=sum+root.value;
		if(root.left==null && root.right==null){
			System.out.println("Leaf:::"+root.value+"  sum::"+sum);
			return;
		}
		allPathSumDFS(root.left,sum);
		allPathSumDFS(root.right,sum);
		}
	}
	
	public static void printSumOfDigits(int digit){
		int sum=0;
		System.out.print("0");
		while(digit!=0)
		{
			sum=sum+digit%10;
			System.out.print("+"+digit%10);
			digit=digit/10;
		}
		System.out.println("="+sum);
		
	}
	
	public void printRangeNodes(TreeNode root,int begin,int end){
		
		if(root==null){
			return;
		}
		if(begin<root.value){
			printRangeNodes(root.left,begin,end);
		}
		if(root.value>=begin && root.value<=end){
			System.out.println(root);
		}
		if(end>root.value ){
			printRangeNodes(root.right,begin,end);
		}
		
	}
	
	
	Node node;
	public TreeNode sortedListToBST(int start,int end){
		if(start>end)
			return null;
		
		int mid = (start + end) / 2;
		 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(node.value);
		System.out.println("Node:"+node.value);
		node = node.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
		
		
	}
	public static void spiralOrder(TreeNode root){
		System.out.println("\n**********Spiral*************");
		Stack<TreeNode> stack1= new Stack<TreeNode>();
		Stack<TreeNode> stack2= new Stack<TreeNode>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			while(!stack1.isEmpty())
			{
				TreeNode node= stack1.pop();
				System.out.print(node+">");
				if(node.right!=null)
					stack2.push(node.right);
				if(node.left!=null)
					stack2.push(node.left);
				
			}
			while (!stack2.isEmpty())
			{
				TreeNode node=stack2.pop();
				System.out.print(node+">");
				if(node.left!=null)
					stack1.push(node.left);
				if(node.right!=null)
					stack1.push(node.right);
				
			}
			
			
		}
		
		
		
		
		
	}
	
	public static int getHeight(TreeNode node){
		int level=0;
		while(node.parent!=null){
			level++;
			node=node.parent;
		}
		return level;
	}
	
	public static void BFS(TreeNode q[],int head,int tail){
		TreeNode headNode=q[head];
		if(head<tail && headNode!=null){
			head=head+1;
			System.out.print(""+headNode+">");
			if(headNode.left!=null)
			q[tail++]=headNode.left;
			if(headNode.right!=null)
			q[tail++]=headNode.right;
			BFS(q, head, tail);
			
			
		}
		
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
	
	
	public static Node getLinkedList(){
		Node start = new Node(1);
		Node pointer =start;
		new TestLinkedList().addNode(pointer, 5);
		pointer= pointer.next;
		new TestLinkedList().addNode(pointer, 6);
		pointer= pointer.next;
		new TestLinkedList().addNode(pointer, 9);
		pointer= pointer.next;
		new TestLinkedList().addNode(pointer, 10);
		pointer= pointer.next;
		new TestLinkedList().addNode(pointer, 13);
		pointer= pointer.next;
		
		new TestLinkedList().addNode(pointer, 15);
		pointer= pointer.next;
		
		new TestLinkedList().addNode(pointer, 17);
		pointer= pointer.next;
		new TestLinkedList().addNode(pointer, 19);
		pointer= pointer.next;
		return start;
	}
	
	
}
