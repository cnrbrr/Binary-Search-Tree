
public interface ICollection {
	void add(int obj) throws DuplicateNodeException;
	int size();
	int size(BinaryTreeNode subtree);
	boolean remove(int element);
	BinaryTreeNode findNode(int look, BinaryTreeNode node);
	void union(BinaryTreeNode node1, BinaryTreeNode node2) throws DuplicateNodeException;
	void flatten(BinaryTreeNode node);
}
