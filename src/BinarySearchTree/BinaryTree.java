package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	static int nodeSum = 0;

	public Node createNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		} else {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.data + " ");
			inOrder(node.left);
			inOrder(node.right);
		}
	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		} else {
			inOrder(node.left);
			inOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

	// this is using the static method
	public int allNodeSum(Node node) {
		if (node == null) {
			return 0;
		} else {
			allNodeSum(node.left);
			allNodeSum(node.right);
			nodeSum = nodeSum + node.data;
		}

		return nodeSum;
	}

	// this is for total sum using two recursions
	public int twoSum(Node node) {
		if (node == null) {
			return 0;
		} else {
			int sum = node.data + twoSum(node.left) + twoSum(node.right);
			// int right=node.data+;
			return sum;
		}
	}

	// to get the sum of even and odd levels
	public int evenOddDiff(Node node) {
		if (node == null) {
			return 0;
		} else {
			int diff = node.data - evenOddDiff(node.left) - evenOddDiff(node.right);
			return diff;
		}
	}

	// number of nodes in a tree
	public int noOfNodes(Node node) {
		if (node == null) {
			return 0;
		} else {
			int num = 1 + noOfNodes(node.left) + noOfNodes(node.right);
			return num;
		}
	}

	// number of leaves in a tree
	//only keeping one side null will give the count of node with one missing child also.
	public int noOfLeaves(Node node) {
		if (node == null) {
			return 0;
		} else if(node.left==null && node.right==null) {
			return 1;
		}
		else {
			int leaf = noOfLeaves(node.left)+noOfLeaves(node.right);
			return leaf;
		}
	}
	//getting height of the binary tree
	public int getHeight(Node node) {
		if(node==null) {
			return 0;
		}else {
			int left=1+getHeight(node.left);
			int right=1+getHeight(node.right);
			int max=Math.max(left, right);
			return max;
		}
	}
	
	//printing elements of a level 
	public void printLevelElem(Node node,int level) {
		if(node==null) {
			return;
		}else if(level==1) {
			System.out.print(node.data+",");
			return;
		}else {
			printLevelElem(node.left,level-1);
			printLevelElem(node.right,level-1);
		}
	}
	
	//level order printing of the tree
	public void levelOrderPrint(Node node) {
		if(node==null) {
			return;
		}else {
			int height=getHeight(node);
			for(int i=1;i<=height;i++) {
				printLevelElem(node,i);
				System.out.println();
			}
		}
	}
	
	//level order traversal without recursion
	public void levelOrderQueue(Node node) {
		if(node==null) {
			return;
		}else {
			Queue<Node> qu=new LinkedList<Node>();
			qu.add(node);
			while(!qu.isEmpty()) {
				Node top=qu.remove();
				System.out.print(top.data+",");
				
				if(top.left!=null) {
					qu.add(top.left);
				}
				
				if(top.right!=null) {
					qu.add(top.right);
				}
			}
		}
	}
	
	//reverse level order traversal without recursion
	public void reverLevelOrderQueue(Node node) {
		if(node==null) {
			return;
		}else {
			Queue<Node> qu=new LinkedList<Node>();
			qu.add(node);
			
			Stack<Node> st=new Stack<Node>();
			
			while(!qu.isEmpty()) {
				Node top=qu.remove();
				//System.out.println(top.data);
				if(top.right!=null) {
					qu.add(top.right);
				}
				
				if(top.left!=null) {
					qu.add(top.left);
				}
				st.push(top);
			}
			
			while(!st.isEmpty()) {
				System.out.print(st.pop().data+",");
			}
		}
	}
	
	//level order without recursion level by level
	public void levelStepQueue(Node node) {
		if(node==null) {
			return;
		}else {
			Queue<Node> qu=new LinkedList<Node>();
			qu.add(node);
			while(true) {
				int count=qu.size();
				if(count==0) {
					break;
				}
				while(count>0) {
					Node top=qu.remove();
					System.out.print(top.data+" ");
					if(top.left!=null) {
						qu.add(top.left);
					}
					
					if(top.right!=null) {
						qu.add(top.right);
					}
					count--;
				}
				System.out.println();
			}
		}
	}
}
