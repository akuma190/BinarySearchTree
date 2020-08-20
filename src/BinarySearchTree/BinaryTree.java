package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {
	static int nodeSum = 0;

	public Node createNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	// creating node with height
	public NodeHeight createNewNode(int data) {
		NodeHeight node = new NodeHeight();
		node.left = null;
		node.right = null;
		node.data = data;
		return node;
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

	// To get the level of a binary tree
	// if it is found in the left side then recursion wont go to right side.
	public int getLevelOfNode(Node node, int val, int level) {
		if (node == null) {
			return 0;
		}

		int l;

		if (node.data == val) {
			return level;
		}

		l = getLevelOfNode(node.left, val, level + 1);

		if (l != 0) {
			return l;
		}

		l = getLevelOfNode(node.right, val, level + 1);

		return l;
	}

	// printing the top view of a binary tree
	// in treemap we can store in ascending or descending order.
	public void prinTopView(NodeHeight node) {
		if (node == null) {
			return;
		} else {
			TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
			Queue<NodeHeight> qu = new LinkedList<NodeHeight>();
			// System.out.println(node.height);
			qu.add(node);
			while (!qu.isEmpty()) {
				NodeHeight top = qu.remove();
				int hi = top.height;

				if (tree.get(hi) == null) {
					tree.put(hi, top.data);
				}

				if (top.left != null) {
					top.left.height = hi - 1;
					qu.add(top.left);
				}

				if (top.right != null) {
					top.right.height = hi - 1;
					qu.add(top.right);
				}
			}
			System.out.println(tree.values());
		}
	}

	// this is to give the bottom view of the binary tree.
	public void bottomView(NodeHeight node) {
		if (node == null) {
			return;
		}

		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		Queue<NodeHeight> q = new LinkedList<NodeHeight>();
		q.add(node);

		while (!q.isEmpty()) {
			NodeHeight temp = q.remove();
			int hd = temp.height;

			m.put(hd, temp.data);

			if (temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}
	// printing the boundary of a binary search tree
	// first print the left side then the leaf nodes then the right side.

//	public void printBoundary(Node node) {
//	    if (node != null) {
//	      System.out.print(node.data + " ");
//
//	      printBoundaryLeft(node.left);
//
//	      printLeaves(node.left);
//	      printLeaves(node.right);
//
//	      printBoundaryRight(node.right);
//	    }
//	  }

	public void printLeftBoundary(Node node) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			printLeftBoundary(node.right);
		}
	}

	public void printRightBoundary(Node node) {
		if (node == null) {
			return;
		}

		if (node.right != null) {
			System.out.print(node.data + " ");
			printRightBoundary(node.right);
		} else if (node.left != null) {
			System.out.print(node.data + " ");
			printRightBoundary(node.left);
		}
	}

	public void printLeaveNodes(Node node) {
		if (node == null) {
			return;
		} else if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		} else {
			printLeaveNodes(node.left);
			printLeaveNodes(node.right);
		}
	}

	// this method will be used to print by vertical level
	public void printVerticalOrder(Node node) {
		if (node == null) {
			return;
		} else {
			int height = 0;
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
			printInterVertOrder(map, node, height);
			for (Map.Entry<Integer, ArrayList<Integer>> cm : map.entrySet()) {
				System.out.println(cm.getValue());
			}
		}
	}

	public void printInterVertOrder(TreeMap<Integer, ArrayList<Integer>> map, Node node, int height) {
		if (node == null) {
			return;
		} else {
			if (map.get(height) == null) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(node.data);
				map.put(height, list);
			} else {
				ArrayList<Integer> list = map.get(height);
				list.add(node.data);
				map.put(height, list);
			}
			printInterVertOrder(map, node.left, height - 1);
			printInterVertOrder(map, node.right, height + 1);
		}
	}

	// this method will be used to print by vertical level
	public void sumVerticalOrder(Node node) {
		if (node == null) {
			return;
		} else {
			int height = 0;
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			sumInterVertOrder(map, node, height);
			for (Map.Entry<Integer, Integer> cm : map.entrySet()) {
				System.out.println(cm.getValue());
			}
		}
	}

	public void sumInterVertOrder(TreeMap<Integer, Integer> map, Node node, int height) {
		if (node == null) {
			return;
		} else {
			if (map.get(height) == null) {
				map.put(height, node.data);
			} else {
				int sum = map.get(height);
				map.put(height, (sum + node.data));
			}
			sumInterVertOrder(map, node.left, height - 1);
			sumInterVertOrder(map, node.right, height + 1);
		}
	}

	// to print the sum of all the elements at a particular level
	// size will represent the number of elements at that level and that will be the
	// nof of iterations for us.
	public void sumEachLevel(Node node) {
		if (node == null) {
			return;
		} else {
			int sum = 0;
			Queue<Node> qu = new LinkedList<Node>();
			qu.add(node);
			while (true) {
				int size = qu.size();
				if (size == 0) {
					break;
				}
				sum = 0;
				while (size > 0) {
					Node top = qu.remove();
					sum = sum + top.data;
					if (top.left != null) {
						qu.add(top.left);
					}

					if (top.right != null) {
						qu.add(top.right);
					}
					size = size - 1;
				}
				System.out.println(sum);
			}
		}
	}

	// search recursively
	public boolean serachBinaryTree(Node node, int val) {
		if (node == null) {
			return false;
		} else if (node.data == val) {
			return true;
		} else {
			boolean left = serachBinaryTree(node.left, val);
			boolean right = serachBinaryTree(node.right, val);
			return left || right;
		}
	}

	// searching iteratively
	public boolean iterativeSearch(Node node, int key) {
		if (node == null) {
			return false;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while (!q.isEmpty()) {
			Node t = q.remove();
			if (t.data == key) {
				return true;
			}

			if (t.left != null) {
				q.add(t.left);
			}

			if (t.right != null) {
				q.add(t.right);
			}
		}

		return false;
	}

	// printing a binary tree in spiral form
	// this can be done using two stacks.
	public void printSpiralForm(Node node) {
		if (node == null) {
			return;
		} else {
			Stack<Node> st1 = new Stack<Node>();
			Stack<Node> st2 = new Stack<Node>();
			st1.push(node);
			while (!st1.isEmpty() || !st2.isEmpty()) {

				while (!st1.isEmpty()) {
					Node top = st1.pop();
					System.out.print(top.data + " ");
					if (top.right != null) {
						st2.push(top.right);
					}

					if (top.left != null) {
						st2.push(top.left);
					}
				}
				System.out.println();
				while (!st2.isEmpty()) {
					Node top1 = st2.pop();
					System.out.print(top1.data + " ");
					if (top1.left != null) {
						st1.push(top1.left);
					}
					if (top1.right != null) {
						st1.push(top1.right);
					}
				}
				System.out.println();
			}
		}
	}

	// printing the elements between any two levels
	public void printBetweenLevels(Node node, int min, int max) {
		if (node == null) {
			return;
		} else {
			int level = 1;
			Queue<Node> qu = new LinkedList<Node>();
			qu.add(node);
			while (true) {
				int size = qu.size();
				if (size < 0 || level > max) {
					break;
				}

				while (size > 0) {
					Node top = qu.remove();
					if (level >= min && level <= max) {
						System.out.print(top.data + " ");
					}
					if (top.right != null) {
						qu.add(top.right);
					}
					if (top.left != null) {
						qu.add(top.left);
					}
					size = size - 1;
				}
				level = level + 1;
				System.out.println();
			}
		}
	}

	// finding the maximum width of any level of a binary tree.
	public int getMaximumWidth(Node node) {
		if (node == null) {
			return 0;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		int maxWidth = 1;

		while (true) {
			int size = q.size();
			if (size == 0) {
				break;
			}

			if (size > maxWidth) {
				maxWidth = size;
			}

			while (size > 0) {
				Node t = q.remove();

				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}
				size--;

			}
		}

		return maxWidth;
	}

	// checking if two trees are mirror to each other or not
	public boolean checkMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) {
			return false;
		} else if (node1.data != node2.data) {
			return false;
		} else {
			boolean left = checkMirror(node1.left, node2.right);
			boolean right = checkMirror(node1.right, node2.left);
			return left && right;
		}
	}
	// checking if two binary tree are only mirror strucure the data here won't
	// matter

	public boolean checkMirrorStruct(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		} else if (node1 == null || node2 == null) {
			return false;
		} else {
			boolean left = checkMirrorStruct(node1.left, node2.right);
			boolean right = checkMirrorStruct(node1.right, node2.left);
			return left && right;
		}
	}

	// checking if the two trees have the same structure.
	// as we are checking all the nodes then time complexity will be O(n)
	public boolean ifSameStructure(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return ifSameStructure(node1.left, node2.left) && ifSameStructure(node1.right, node2.right);
	}

	// to check if the binary tree is foldable tree or not.
	// In this we need to identify whether the left and right subtree are mirror
	// structure or not.
	public boolean ifFoldableTree(Node node) {
		if (node == null) {
			return true;
		}

		return ifMirrorStructure(node.left, node.right);
	}

	public boolean ifMirrorStructure(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return ifMirrorStructure(node1.left, node2.right) && ifMirrorStructure(node1.right, node2.left);
	}

	// to check if two binary tree are isomorphic
	// we check both the left and right element if they are same.
	// compleifity O(left+right)
	public boolean ifIsomorphic(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		if (node1.data != node2.data) {
			return false;
		}

		return (ifIsomorphic(node1.left, node2.left) && ifIsomorphic(node1.right, node2.right))
				|| (ifIsomorphic(node1.left, node2.right) && ifIsomorphic(node1.right, node2.left));
	}

	// getting the widht of a level in binary tree.
	// number of nodes at that level
	public int getWidthOfLevel(Node node, int level) {
		if (node == null) {
			return 0;
		}

		if (level == 1) {// we have reached th desirde level.
			return 1;
		}

		return getWidthOfLevel(node.left, level - 1) + getWidthOfLevel(node.right, level - 1);
	}

	// creating a double tree out of the given binary tree.
	// each node should be added to the left side.
	// we are iterating each node so O(n)
	public void doubleTree(Node node) {
		if (node == null) {
			return;
		}

		doubleTree(node.left);
		doubleTree(node.right);

		Node newNode = createNode(node.data);
		newNode.left = node.left;
		node.left = newNode;
	}

	// creating a binary tree fromt he inorder and pre order traverasal.
	// 2,4,7,3,8
	// 7,4,3,2,8
	// we will hvae the preorder and inorder array.
	// we are searching for each element of inorder in preorder thus O(n2)
	int preIndex;

	public Node buildTreeFromInOrderPreOrder(int preorderArray[], int inorderArray[], int start, int end) {
		if (start > end) {
			return null;
		}

		Node node = createNode(preorderArray[preIndex++]);

		if (start == end) {
			return node;
		}

		int inoderIndex = getInorderIndex(node.data, inorderArray, start, end);

		node.left = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, start, inoderIndex - 1);
		node.right = buildTreeFromInOrderPreOrder(preorderArray, inorderArray, inoderIndex + 1, end);

		return node;
	}

	private int getInorderIndex(int val, int in[], int start, int end) {
		for (int i = start; i <= end; i++) {
			if (in[i] == val) {
				return i;
			}
		}

		return -1;
	}

	// getting the height of the binary tree by iteration.
	// time complexity is O(n)
	public int heightIteratively(Node node) {
		if (node == null) {
			return -1;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int height = 0;

		while (true) {
			int size = q.size();
			if (size == 0) {
				break;
			}

			while (size > 0) {
				Node t = q.remove();
				if (t.left != null) {
					q.add(t.left);
				}

				if (t.right != null) {
					q.add(t.right);
				}

				size--;
			}

			height = height + 1;
		}
		return height;
	}

	// getting the diameter of the binary tree.
	// diameter is the distance between any two leaf nodes.
	// for each node we tak the sum of max elements from left and right side then
	// add 1.
	// the node which gives the mas sum has the max diameter.
	// O(n)*(O(n)+O(n))
	int diameter;

	public int getDiameter(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		int lH = getDiameter(node.left);
		int rH = getDiameter(node.right);

		diameter = Math.max(diameter, lH + rH + 1);

		return Math.max(lH, rH) + 1;// this will geive the number of node to the left or right of a node
	}

	// if the binary tree is a height balanced tree.
	// for any node the difference between the left height and right height should
	// not be more than 1.
	public int ifHeightBalancedTree(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		int lH = ifHeightBalancedTree(node.left);
		int rH = ifHeightBalancedTree(node.right);

		if (lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
			return -1;
		}

		return Math.max(lH, rH) + 1;
	}

	// to check if the given sum is equal to the sum of nodes in the binary tree.
	public boolean ifRootToLeafPathSumMatches(Node node, int total) {
		if (node == null) {
			return false;
		}

		if (node.left == null && node.right == null && total == node.data)
			return true;

		return ifRootToLeafPathSumMatches(node.left, total - node.data)
				|| ifRootToLeafPathSumMatches(node.right, total - node.data);
	}

	// to print every path in a binary search tree.
	// use an array and then keep on adding the value in the array.
	// time complexitt as we cover each element O(n).
	// Space complexityO(n)
	public void printRootToLeaf(Node node) {
		if (node == null) {
			return;
		}

		int arr[] = new int[10];
		printRootToLeafImpl(node, arr, 0);
	}

	private void printRootToLeafImpl(Node node, int[] arr, int index) {
		if (node == null) {
			return;
		}

		arr[index] = node.data;

		if (node.left == null && node.right == null) {
			printArray(arr, index);
		}

		printRootToLeafImpl(node.left, arr, index + 1);
		printRootToLeafImpl(node.right, arr, index + 1);
	}

	private void printArray(int[] arr, int index) {
		for (int i = 0; i <= index; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// find the max sum from root to leaf.
	int maxSum;

	public void maxSumFromRootToLeaf(Node node, int sum) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && sum + node.data > maxSum) {
			maxSum = sum + node.data;
			return;
		}

		maxSumFromRootToLeaf(node.left, sum + node.data);
		maxSumFromRootToLeaf(node.right, sum + node.data);
	}

	// sum of all the numbers from the root to leaf in binary treee.
	int sumRootToLeaf;

	public void sumRootToLeaf(Node node, int i) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			sumRootToLeaf = sumRootToLeaf + (i * 10 + node.data);
			return;
		}

		sumRootToLeaf(node.left, i * 10 + node.data);
		sumRootToLeaf(node.right, i * 10 + node.data);
	}

	// finding the min and max value of a binary tree.
	int maximum = Integer.MIN_VALUE;
	int minimum = Integer.MAX_VALUE;

	public void findMinMaxValue(Node node) {
		if (node == null) {
			return;
		}

		if (node.data > maximum) {
			maximum = node.data;
		}

		if (node.data < minimum) {
			minimum = node.data;
		}

		findMinMaxValue(node.left);
		findMinMaxValue(node.right);
	}

	// getting the minimum height of the tree.
	// one og the ways is to do it by level order traversal.
	public int findMinHeightLevelwise(Node node) {
		if (node == null) {
			return 0;
		}

		int height = 1;

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (true) {
			int size = queue.size();

			if (queue.isEmpty() || size == 0) {
				break;
			}

			while (size > 0) {
				Node temp = queue.remove();

				if (temp.left == null && temp.right == null) {
					return height;
				}

				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}

				size--;
			}

			height++;
		}

		return height;
	}

	// other using recursion.
	public int minHeight(Node node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		if (node.left == null) {
			return minHeight(node.right) + 1;
		}

		if (node.right == null) {
			return minHeight(node.left) + 1;
		}

		return Math.min(minHeight(node.left), minHeight(node.right)) + 1;
	}

	// recursive
	int minHeight = Integer.MAX_VALUE;

	public void findMinHeightRecursive(Node node, int height) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && height < minHeight) {
			minHeight = height;
		}

		findMinHeightRecursive(node.left, height + 1);
		findMinHeightRecursive(node.right, height + 1);
	}
	//getting the sum of all leaf nodes.

}
