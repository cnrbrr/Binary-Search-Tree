
public interface ISet {
	BinaryTreeNode getBTN();
	void setBTN(BinaryTreeNode node);
	void add(int value) throws DuplicateNodeException;
	void remove(int value);
}
