package org.ligson.designmode.structure.composite;

public class Tree {
	TreeNode root = null;

	public Tree(String name) {
		root = new TreeNode(name);
	}
	
	public void test() {
		//     A
		//    /|\
		//   B C D
		//  /| |
		// E F G
		Tree tree =new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		TreeNode nodeD = new TreeNode("D");
		TreeNode nodeE = new TreeNode("E");
		TreeNode nodeF = new TreeNode("F");
		TreeNode nodeG = new TreeNode("G");
		nodeB.add(nodeE);
		nodeB.add(nodeF);
		nodeC.add(nodeG);
		tree.root.add(nodeB);
		tree.root.add(nodeC);
		tree.root.add(nodeD);
	}
}
