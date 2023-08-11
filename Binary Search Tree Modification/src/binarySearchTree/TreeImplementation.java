package binarySearchTree;

import java.util.Scanner;

public class TreeImplementation implements TreeInterface {

	Scanner scan = new Scanner(System.in);

	@Override
	public Node createBinarySearchTree(Node root) {

		System.out.print("Number of nodes in the Binary Search Tree: ");
		int m = scan.nextInt();

		if (m < 1) {
			throw new RuntimeException("Invalid entry. Number of nodes must be a positive integer to create a tree.");
		}

		System.out.println();
		System.out.println("Provide all the node data: ");
		System.out.println();

		for (int i = 0; i < m; i++) {
			System.out.print((i + 1) + ") ");
			root = insertData(root, scan.nextInt());
		}

		System.out.println("\nBinary Search Tree (BST) created successfully!");

		return root;
	}

	private Node insertData(Node root, int value) {

		// Creating Binary Search Tree by inserting data

		if (root == null) {
			return newNode(value);
		}
		if (root.nodeData > value) {
			root.leftNode = insertData(root.leftNode, value);
		} else if (root.nodeData == value) {
			System.out.println("Duplicate value not allowed. New node not created.");
		} else {
			root.rightNode = insertData(root.rightNode, value);
		}
		return root;
	}

	private Node newNode(int nodeData) {

		// creating new node

		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}
}
