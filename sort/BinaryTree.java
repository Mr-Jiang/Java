package sort;

/**
 * Java二叉树遍历、反转
 * 
 * @author Administrator
 * 
 */
public class BinaryTree {

	public static void main(String[] args) {

		int[] values = { 2, 14, 4, 10, 7, 16, 1, 12, 3, 20, 5, 11, 0, 9, 6, 8 };

		BinaryTree binaryTree = new BinaryTree();

		for (int i = 0; i < values.length; i++) {
			binaryTree.buildTree(binaryTree.root, values[i]);
		}

		System.out.println("中序遍历");
		binaryTree.inOrder(binaryTree.root);

		System.out.println("\n前序遍历");
		binaryTree.preOrder(binaryTree.root);

		System.out.println("\n后序遍历");
		binaryTree.postOrder(binaryTree.root);

		System.out.println("\n反转左右子树，递归");
		binaryTree.reverse(binaryTree.root);

		// System.out.println("\n反转左右子树，非递归");
		// binaryTree.reverseNoRecursive(binaryTree.root);
	}

	public Node root;

	/**
	 * 递归创建二叉树
	 * 
	 * @param node
	 * @param data
	 */
	public void buildTree(Node node, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < node.data) {
				if (node.left == null) {
					node.left = new Node(data);
				} else {
					buildTree(node.left, data);
				}
			} else {
				if (node.right == null) {
					node.right = new Node(data);
				} else {
					buildTree(node.right, data);
				}
			}
		}
	}

	/**
	 * 前序遍历
	 * 
	 * @param node
	 */
	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + ", ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + ", ");
			inOrder(node.right);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + ", ");
		}
	}

	/**
	 * 反转二叉树 - 递归
	 * 
	 * @param node
	 */
	public void reverse(Node node) {
		if (node != null) {
			reverse(node.left);
			reverse(node.right);
			Node left = node.left;
			node.left = node.right;
			node.right = left;
		}
	}

	/**
	 * 反转二叉树 - 非递归
	 * 
	 * @param node
	 */
	public void reverseNoRecursive(Node node) {
		if (node == null) {
			return;
		}
		// public class Stack<E> extends Vector<E>
		java.util.Stack<Node> stack = new java.util.Stack<Node>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node nodeItem = stack.pop();
			Node left = nodeItem.left;
			nodeItem.left = nodeItem.right;
			nodeItem.right = left;
			if (nodeItem.left != null) {
				stack.push(nodeItem.left);
			}
			if (nodeItem.right != null) {
				stack.push(nodeItem.right);
			}
		}

	}

	class Node {

		public int data;

		public Node left;

		public Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
