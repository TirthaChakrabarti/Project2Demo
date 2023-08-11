package main;

import binarySearchTree.Node;
import binarySearchTree.TreeImplementation;
import bstModification.BSTModificationImplementation;

public class Driver {

	public static void main(String[] args) {

		try {

			Node root = null;

			TreeImplementation tree = new TreeImplementation();
			Node rootBST = tree.createBinarySearchTree(root);

			BSTModificationImplementation modbst = new BSTModificationImplementation();
			modbst.displayNodesInAscendingOrder(rootBST);

		} catch (RuntimeException e) {
			System.out.println("\nAn exception occured: \n" + e.getMessage());
		}
	}
}
