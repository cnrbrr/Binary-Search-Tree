import java.util.ArrayList;


public class BinaryTreeCollection implements ICollection{
	BinaryTreeNode root = null;
	ArrayList<Integer> unionList = new ArrayList<Integer>();

	@Override
	public void add(int obj) throws DuplicateNodeException {//adds the new node value
		BinaryTreeNode node = new BinaryTreeNode(obj);
		if (root == null){//if nothing in the tree add it
			root = node;
		}else{ 
			add(node, root);
		}	
	} 

	private void add(BinaryTreeNode subtree, BinaryTreeNode parent) throws DuplicateNodeException {
		if (subtree != null){//makes sure there is a value to add
			if(subtree.element == parent.element){ //if it has already been added throw an error
				throw new DuplicateNodeException();
			}
			//if the element being added is less than go to the left
			if (subtree.element < parent.element){ 
				if (parent.left == null) {//if its null add it
					parent.left = subtree;
				} else {//if not null look for a null value
					add(subtree, parent.left);
				}

			} else {//if more than go right
				if(parent.right == null){//if null add it
					parent.right = subtree;

				} else{//or loop again moving down the tree
					add(subtree, parent.right);
				}

			}
		}
	}


	@Override
	public boolean remove(int value) {//remove this value
		if (root == null)//if there is nothing there then false
			return false;
		else {
			if (root.element == value) {//if the value is this then
				BinaryTreeNode auxRoot = new BinaryTreeNode(0);//temporary node
				auxRoot.setLeft(root);
				boolean result = root.remove(value, auxRoot);
				root = auxRoot.getLeft();
				return result;
			} else {
				return root.remove(value, null);
			}
		}
	}



	@Override
	public BinaryTreeNode findNode(int look, BinaryTreeNode node) {//find a specific node
		if(look == node.element){//if it is the one being looked for
			return node;//return
		} 

		if(look < node.element){//if less go left
			while(node.left != null){//loop through till null
				if(look == node.left.element){//if its to the left
					return node.left;//return
				} else {//or recurse
					node = findNode(look, node.left);
				}
			}
		}

		if(look > node.element){//if greater go right
			while(node != null){
				if(look == node.element){
					return node;
				} else {
					node = findNode(look, node.right);

				}

			}
		}


		return null;//return the node when it's found
	}


	@Override
	public int size(BinaryTreeNode subtree) {//get the size of this tree
		if (subtree == null){//if null its 0 size
			return 0;
		}else{
			return 1 + size(subtree.left) + size(subtree.right);
		}

	}

	@Override
	public int size() {
		return size(root);
	}


	public void printStuff(BinaryTreeNode node){
		//pretty much just a link to BTN
		node.printTree();

	}

	@Override
	public void union(BinaryTreeNode node1, BinaryTreeNode node2) throws DuplicateNodeException{
		Object[] unionArray;//new array

		unionList.add(node1.element);//add the first value of
		unionList.add(node2.element);//both of the trees

		flatten(node1);//flatten both of
		flatten(node2);//the trees

		unionArray = unionList.toArray();//turn the arraylist into an array

		root = null;//delete the original tree
		for(int i = 0; i < unionArray.length; i++){
			add((int)unionArray[i]);
		}

	}

	@Override
	public void flatten(BinaryTreeNode node){//use to flatten the trees

		try{
			if(node.left != null){//if left has a value
				unionList.add(node.left.element);//add this value then move to the left
				flatten(node.left);
			}

			if(node.right != null){//same but to the right
				unionList.add(node.right.element);
				flatten(node.right);
			}
		} catch(NullPointerException e){//if it's null continue

		}	
	}
}
