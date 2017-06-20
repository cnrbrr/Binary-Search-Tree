import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {
	BinaryTreeCollection bTC = new BinaryTreeCollection();
	BinaryTreeCollection bTC2 = new BinaryTreeCollection();
	Set littleSet = new Set();



	@Test
	public void size() throws DuplicateNodeException{//tests if size works
		for(int i = 1; i < 11; i++)
			bTC.add(i);

		assertTrue(bTC.size() == 10);
	}

	@Test
	public void add() throws DuplicateNodeException{//tests if add works

		bTC.add(3);
		bTC.add(12);
		bTC.add(9);
		bTC.add(0);
		bTC.add(-6);
		bTC.add(1);

		assertTrue(bTC.size() == 6);
	}

	@Test(expected=DuplicateNodeException.class)
	public void addError() throws DuplicateNodeException{//tests if add doesn't allow duplicates

		bTC.add(3);
		bTC.add(3);
	}

	@Test
	public void remove() throws DuplicateNodeException {//tests if remove works

		bTC.add(4);
		bTC.add(3);
		bTC.add(2);
		bTC.add(5);
		bTC.add(6);
		bTC.remove(5);


		assertTrue(bTC.size() == 4);

	}

	@Test
	public void union() throws DuplicateNodeException {//tests if union works

		bTC.add(4);
		bTC.add(3);
		bTC.add(2);
		bTC.add(6);
		bTC.add(5);

		bTC2.add(-2);
		bTC2.add(-3);
		bTC2.add(-4);
		bTC2.add(-5);
		bTC2.add(-6);

		bTC.union(bTC.root, bTC2.root);

		assertTrue(bTC.size() == 10);

	}

	@Test(expected=DuplicateNodeException.class)
	public void unionError() throws DuplicateNodeException {//tests if union throws the right error

		bTC.add(4);
		bTC2.add(4);


		bTC.union(bTC.root, bTC2.root);
	}

	@Test
	public void findNode() throws DuplicateNodeException{//tests if find node works

		bTC.add(3);
		bTC.add(12);
		bTC.add(9);
		bTC.add(0);
		bTC.add(-6);
		bTC.add(1);


		assertTrue(bTC.findNode(9, bTC.root).element == 9);
	}

	@Test(expected=NullPointerException.class)
	public void findNodeError() throws DuplicateNodeException{//tests if find node works

		bTC.add(3);
		bTC.add(12);
		bTC.add(9);
		bTC.add(0);
		bTC.add(-6);
		bTC.add(1);


		bTC.findNode(8, bTC.root);
	}

	@Test
	public void setAdd() throws DuplicateNodeException{ //tests if the set works
		littleSet.add(3);
		assertTrue(littleSet.size() == 1);
	}

	@Test
	public void setRemove() throws DuplicateNodeException{
		littleSet.add(3);
		littleSet.add(5);
		littleSet.remove(3);
		assertTrue(littleSet.size() == 1);
	}

}
