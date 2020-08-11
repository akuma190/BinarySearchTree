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
	// only keeping one side null will give the count of node with one missing child
	// also.
	public int noOfLeaves(Node node) {
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return 1;
		} else {
			int leaf = noOfLeaves(node.left) + noOfLeaves(node.right);
			return leaf;
		}
	}

	// getting height of the binary tree
	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			int left = 1 + getHeight(node.left);
			int right = 1 + getHeight(node.right);
			int max = Math.max(left, right);
			return max;
		}
	}

	// printing elements of a level
	public void printLevelElem(Node node, int level) {
		if (node == null) {
			return;
		} else if (level == 1) {
			System.out.print(node.data + ",");
			return;
		} else {
			printLevelElem(node.left, level - 1);
			printLevelElem(node.right, level - 1);
		}
	}

	// level order printing of the tree
	public void levelOrderPrint(Node node) {
		if (node == null) {
			return;
		} else {
			int height = getHeight(node);
			for (int i = 1; i <= height; i++) {
				printLevelElem(node, i);
				System.out.println();
			}
		}
	}

	// level order traversal without recursion
	public void levelOrderQueue(Node node) {
		if (node == null) {
			return;
		} else {
			Queue<Node> qu = new LinkedList<Node>();
			qu.add(node);
			while (!qu.isEmpty()) {
				Node top = qu.remove();
				System.out.print(top.data + ",");

				if (top.left != null) {
					qu.add(top.left);
				}

				if (top.right != null) {
					qu.add(top.right);
				}
			}
		}
	}

	// reverse level order traversal without recursion
	public void reverLevelOrderQueue(Node node) {
		if (node == null) {
			return;
		} else {
			Queue<Node> qu = new LinkedList<Node>();
			qu.add(node);

			Stack<Node> st = new Stack<Node>();

			while (!qu.isEmpty()) {
				Node top = qu.remove();
				// System.out.println(top.data);
				if (top.right != null) {
					qu.add(top.right);
				}

				if (top.left != null) {
					qu.add(top.left);
				}
				st.push(top);
			}

			while (!st.isEmpty()) {
				System.out.print(st.pop().data + ",");
			}
		}
	}

	// level order without recursion level by level
	public void levelStepQueue(Node node) {
		if (node == null) {
			return;
		} else {
			Queue<Node> qu = new LinkedList<Node>();
			qu.add(node);
			while (true) {
				int count = qu.size();
				if (count == 0) {
					break;
				}
				while (count > 0) {
					Node top = qu.remove();
					System.out.print(top.data + " ");
					if (top.left != null) {
						qu.add(top.left);
					}

					if (top.right != null) {
						qu.add(top.right);
					}
					count--;
				}
				System.out.println();
			}
		}
	}

	// left side view of a binary search tree
	public void leftViewPrint(Node node) {
		if (node.left == null) {
			return;
		}
		leftInterPrint(node.left);
	}

	public void leftInterPrint(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.data);
			leftInterPrint(node.left);
			leftInterPrint(node.right);
		}
	}

	int maxLevel;

	public void leftViewTree(Node node, int level) {
		if (node == null) {
			return;
		} else {
			if (level >= maxLevel) {
				System.out.print(node.data + ",");
				maxLevel = maxLevel + 1;
			}
			// System.out.println(maxLevel+","+level);
			leftViewTree(node.left, level + 1);
			leftViewTree(node.right, level + 1);
		}
	}

	// int maxLevel;
	// right vie of the binary tree.
	public void rightViewTree(Node node, int level) {
		if (node == null) {
			return;
		} else {
			if (level >= maxLevel) {
				System.out.print(node.data + ",");
				maxLevel = maxLevel + 1;
			}
			// System.out.println(maxLevel+","+level);
			rightViewTree(node.right, level + 1);
			rightViewTree(node.left, level + 1);
		}
	}

	// inorder without recursion.
	public void inordNoRec(Node node) {
		if (node == null) {
			return;
		} else {
			Stack<Node> st = new Stack<Node>();
			while (node != null) {
				st.push(node);
				// System.out.println(node.data);
				node = node.left;
			}
			while (!st.isEmpty()) {
				Node top = st.pop();
				System.out.println(top.data + ",");
				if (top.right != null) {
					top = top.right;
					while (top != null) {
						st.push(top);
						top = top.left;
					}
				}
			}
		}
	}

	// pre order without recursion
	public void preOrdNoRec(Node node) {
		if (node == null) {
			return;
		} else {
			Stack<Node> st = new Stack<Node>();
			while (node != null) {
				System.out.print(node.data + ",");
				st.push(node);
				node = node.left;
			}

			while (!st.isEmpty()) {
				Node top = st.pop();
				if (top.right != null) {
					top = top.right;
					while (top != null) {
						System.out.print(top.data + ",");
						st.push(top);
						top = top.left;
					}
				}
			}
		}
	}

	// an alternate method
	public void preorderWithoutRecursion(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> s = new Stack<Node>();

		s.push(node);

		while (s.size() > 0) {
			Node t = s.pop();
			System.out.print(t.data + " ");

			if (t.right != null) {
				s.push(t.right);
			}

			if (t.left != null) {
				s.push(t.left);
			}
		}
	}

	// post order without recursion
	public void postOrderWitRecur(Node node) {
		if (node == null) {
			return;
		} else {
			Stack<Node> st1 = new Stack<Node>();
			Stack<Node> st2 = new Stack<Node>();

			st1.push(node);
			while (!st1.isEmpty()) {
				Node top = st1.pop();
				if (top.left != null) {
					st1.push(top.left);
				}
				if (top.right != null) {
					st1.push(top.right);
				}
				st2.push(top);
			}

			while (!st2.isEmpty()) {
				System.out.print(st2.pop().data + ",");
			}
		}
	}

	// mirroring the binary tree
	public Node mirroBinaryTree(Node node) {
		if (node == null) {
			return null;
		} else {
			Node temp = node.right;
			node.right = node.left;
			node.left = temp;
			mirroBinaryTree(node.left);
			mirroBinaryTree(node.right);

			return node;
		}
	}

	// deleting the whole binary tree
	public Node deleteTree(Node node) {
		if (node == null) {
			return null;
		} else {
			node.left = deleteTree(node.left);
			node.right = deleteTree(node.right);
			System.out.println("deleting node :" + node.data);
			node = null;
			return node;
		}
	}

	// checking if two trees are identical.
	public boolean checkIfIdentical(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1.data != node2.data) {
			return false;
		} else if (node1 == null || node2 == null) {
			return false;
		} else {
			boolean left = checkIfIdentical(node1.left, node2.left);
			boolean right = checkIfIdentical(node1.right, node2.right);
			return left && right;
		}

	}

//	public boolean checkIfIdentical(Node t1, Node t2) {
//		if (t1 == null && t2 == null) {
//			return true;
//		}
//
//		if (t1 == null || t2 == null) {
//			return false;
//		}
//
//		return t1.data == t2.data && checkIfIdentical(t1.left, t2.left) && checkIfIdentical(t1.right, t2.right);
//	}
	
	//To get the level of a binary tree
	//if it is found in the left side then recursion wont go to right side.
	public int getLevelOfNode(Node node, int val, int level) {
	    if(node == null) {
	      return 0;
	    }
	    
	    int l;
	    
	    if(node.data == val) {
	      return level;
	    }
	    
	    l = getLevelOfNode(node.left, val, level + 1);
	    
	    if(l != 0) {
	      return l;
	    }
	    
	    l = getLevelOfNode(node.right, val, level + 1);
	    
	    return l;
	  }
}
