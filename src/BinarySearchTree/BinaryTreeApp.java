package BinarySearchTree;

//2,7,2,6,9,5,11,4
public class BinaryTreeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bst=new BinaryTree();
		Node root=bst.createNode(2);
		root.left=bst.createNode(7);
		root.right=bst.createNode(5);
		root.left.left=bst.createNode(2);
		root.left.right=bst.createNode(6);
		root.left.right.left=bst.createNode(5);
		root.left.right.right=bst.createNode(11);
		root.right.right=bst.createNode(9);
		root.right.right.left=bst.createNode(4);
		
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
		
		System.out.println("The reverse level order print is :");
		bst.reverLevelOrderQueue(root);
		
		System.out.println("The step by step level order :");
		bst.levelStepQueue(root);
		
	}

}
