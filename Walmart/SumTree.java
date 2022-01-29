class SumTree
{
	int data;
	SumTree left, right;

	SumTree(int item)
	{
		data = item;
		left = right = null;
	}
}
class BinaryTree
{
	SumTree root;
	int toSumTree(SumTree node)
	{
		if (node == null)
			return 0;
		int old_val = node.data;
		node.data = toSumTree(node.left) + toSumTree(node.right);
		return node.data + old_val;
	}
	void printInorder(SumTree node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new SumTree(10);
		tree.root.left = new SumTree(-2);
		tree.root.right = new SumTree(6);
		tree.root.left.left = new SumTree(8);
		tree.root.left.right = new SumTree(-4);
		tree.root.right.left = new SumTree(7);
		tree.root.right.right = new SumTree(5);
		tree.toSumTree(tree.root);
		System.out.println("Inorder Traversal of the resultant tree is:");
		tree.printInorder(tree.root);
	}
}