
public class Set implements ISet{
	BinaryTreeCollection btc = new BinaryTreeCollection();;
	BinaryTreeNode node = btc.root;

	@Override
	public BinaryTreeNode getBTN() {
		return node;
	}

	@Override
	public void setBTN(BinaryTreeNode node) {
		this.node = node;

	}

	@Override
	public void add(int value) throws DuplicateNodeException {
		btc.add(value);

	}

	@Override
	public void remove(int value) {
		btc.remove(value);

	}

	public int size(){
		return btc.size();


	}

}
