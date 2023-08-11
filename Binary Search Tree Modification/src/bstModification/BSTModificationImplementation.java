package bstModification;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binarySearchTree.Node;

public class BSTModificationImplementation implements BSTModificationInterface {

	static Queue<Integer> queue = new LinkedList<Integer>();
	static Scanner scan = new Scanner(System.in);
	Node rootRST;

	@Override
	public void displayNodesInAscendingOrder(Node root) {

		System.out.println();
		System.out.println("To display node values present in ascending order, your options:\n");
		System.out.println("1. Modify existing BST to Right-Skewed Tree");
		System.out.println("2. Create a new Right-Skewed Tree using existing BST node values while keeping the BST intact");
		System.out.print("\nChoose you option: ");

		int option = scan.nextInt();

		if ((option < 1) || (option > 2)) {
			throw new RuntimeException("Invalid entry. Option must be 1 or 2.");
		}

		else if (option == 1) {
			rootRST = convertToRightSkewedTree(root);
		}

		else {
			preorderTraversal(root);
			rootRST = createRightSkewedTree(null);
		}

		System.out.println();
		System.out.println("BST node values in ascending order: ");
		printTree(rootRST);
		System.out.println();
	}

	private static Node convertToRightSkewedTree(Node root) {

		if (root == null) {
			return null;
		}

		while (root.leftNode != null) {
			root = rightRotate(root);
		}

		root.rightNode = convertToRightSkewedTree(root.rightNode);

		return root;
	}

	private static Node rightRotate(Node root) {

		if (root == null || root.leftNode == null) {
			return root;
		}

		Node newRoot = root.leftNode;
		root.leftNode = newRoot.rightNode;
		newRoot.rightNode = root;

		return newRoot;
	}

	private void preorderTraversal(Node root) {

		if (root == null) {
			return;
		} else {
			preorderTraversal(root.leftNode);
			queue.add(root.nodeData);
			preorderTraversal(root.rightNode);
		}
	}

	private Node createRightSkewedTree(Node rootRST) {

		while (!queue.isEmpty()) {
			int value = queue.remove();
			rootRST = insertData(rootRST, value);
		}
		return rootRST;
	}

	private Node insertData(Node rootRST, int value) {

		if (rootRST == null) {
			return newNode(value);
		} else {
			rootRST.rightNode = insertData(rootRST.rightNode, value);
		}
		return rootRST;
	}

	private Node newNode(int nodeData) {

		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.rightNode = null;

		return temp;
	}

	private static void printTree(Node root) {

		if (root != null) {
			System.out.print(root.nodeData + " ");
			printTree(root.rightNode);
		}
	}
}
