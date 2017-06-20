
public class BinaryTreeNode {
	public int element;
	public BinaryTreeNode(int obj) {
		this.element = obj;
	}

	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode getLeft(){
		return left;
	}

	public void setLeft(BinaryTreeNode left){
		this.left = left;
	}

	public BinaryTreeNode getRight(){
		return left;
	}

	public void setRight(BinaryTreeNode right){
		this.right = right;
	}

	public boolean remove(int value, BinaryTreeNode parent) {
		if (value < this.element) {//if less go left
			if (left != null)//if it has a value
				return left.remove(value, this);
			else
				return false;
		} else if (value > this.element) { //greater than go right
			if (right != null)//if it has a value
				return right.remove(value, this);
			else
				return false;
		} else {
			if (left != null && right != null) { //if both have values
				this.element = right.minValue();//make it equal to the smallest value
				right.remove(this.element, this);//remove the right
			} else if (parent.left == this) {//or if left is this
				parent.left = (left != null) ? left : right;
			} else if (parent.right == this) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	public int minValue() {//finds the smallest value
		if (left == null)
			return element;
		else
			return left.minValue();
	}


	public void printTree(){//prints the tree properly
		if (right != null) {//checks if there is a value to right
			right.printTree(true, "");
		}
		printNodeValue();//call other method
		if (left != null) {//checks if val to left
			left.printTree(false, "");
		}
	}

	private void printNodeValue(){//print the individual value
		System.out.print(element);
		System.out.print('\n');
	}

	private void printTree(boolean isRight, String indent) {//print the whole tree
		if (right != null) {//checks if val right
			right.printTree(true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {//if true
			System.out.print(" /");
		} else {//if false
			System.out.print(" \\");
		}
		System.out.print("----- ");//line
		printNodeValue();//print the nodes value
		if (left != null) {//checks if val left
			left.printTree(false, indent + (isRight ? " |      " : "        "));
		}
	}
}
