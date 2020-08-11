package BinarySearchTree;

//2,7,2,6,9,5,11,4
public class BinaryTreeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bst=new BinaryTree();
//		Node root=bst.createNode(2);
//		root.left=bst.createNode(7);
//		root.right=bst.createNode(5);
//		root.left.left=bst.createNode(2);
//		root.left.right=bst.createNode(6);
//		root.left.right.left=bst.createNode(5);
//		root.left.right.right=bst.createNode(11);
//		root.right.right=bst.createNode(9);
//		root.right.right.left=bst.createNode(4);
		
		BinaryTree a=new BinaryTree();
		Node root = a.createNode(8);
	    root.left = a.createNode(3);
	    root.right = a.createNode(10);
	    root.left.left = a.createNode(1);
	    root.left.right = a.createNode(6);
	    root.left.right.left = a.createNode(4);
	    root.left.right.right = a.createNode(7);
	    root.right.right = a.createNode(14);
	    root.right.right.left = a.createNode(13);
	    
	    Node root1 = a.createNode(8);
	    root1.left = a.createNode(3);
	    root1.right = a.createNode(10);
	    root1.left.left = a.createNode(1);
	    root1.left.right = a.createNode(6);
	    root1.left.right.left = a.createNode(4);
	    root1.left.right.right = a.createNode(7);
	    root1.right.right = a.createNode(14);
	    root1.right.right.left = a.createNode(18);
		
//		System.out.println("The inorder traversal is");
//		bst.inOrder(root);
//		System.out.println();
//		
//		System.out.println("The postorder traversal is");
//		bst.postOrder(root);
//		System.out.println();
//		
//		System.out.println("The preorder traversal is");
//		bst.preOrder(root);
//		System.out.println();
//				
//		System.out.println("Total sum is :"+bst.allNodeSum(root));
//		
//		System.out.println("Total sum is :"+bst.twoSum(root));
//		
//		System.out.println("The even odd diff is :"+bst.evenOddDiff(root));
//		
//		System.out.println("The no of nodes are :"+bst.noOfNodes(root));
//		
//		System.out.println("The no of leaves are :"+bst.noOfLeaves(root));
//		
//		System.out.println("The height is :"+bst.getHeight(root));
//		
//		System.out.println("The elemnt on level is :");
//		bst.printLevelElem(root, 4);
//		
//		System.out.println("The level order print is :");
//		bst.levelOrderPrint(root);
		
//		System.out.println("The level order print is :");
//		bst.levelOrderQueue(root);
		
//		System.out.println("The reverse level order print is :");
//		bst.reverLevelOrderQueue(root);
		
//		System.out.println("The step by step level order :");
//		bst.levelStepQueue(root);
//		
//		System.out.println("Left view of a binary search tree is :");
//		bst.leftViewPrint(root);
//		
//		System.out.println("Only left elements :");
//		bst.leftViewTree(root,0);
		
//		System.out.println("Only right elements :");
//		bst.rightViewTree(root,0);
		
//		System.out.println("Inorder without recursion :");
//		bst.inordNoRec(root);
		
//		System.out.println("Preorder without recursion :");
//		bst.preOrdNoRec(root);
		
//		System.out.println("PostOrder without recursion :");
//		bst.postOrderWitRecur(root);
//		System.out.println();
//		
//		System.out.println("Mirroring the binary :");
//		Node mirror=bst.mirroBinaryTree(root);
//		bst.inOrder(mirror);
//		System.out.println();
		
//		System.out.println("Deleting the full tree :");
//		bst.deleteTree(root);
//		System.out.println();
		
//		System.out.println("Check if two nodes are identical :");
//		System.out.println(a.checkIfIdentical(root,root1));
//		System.out.println();
		
		System.out.println("Leve of a binar tree :");
		System.out.println(a.getLevelOfNode(root, 7, 1));
		System.out.println();
	}

}
