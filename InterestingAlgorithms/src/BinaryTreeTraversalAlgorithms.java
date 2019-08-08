import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author sid16
 *
 */
										//added this for Generic type support
public class BinaryTreeTraversalAlgorithms<E> {
	
	/**
	 * A Node is visited before it's children.
	 * (Root, Left, Right)
	 * Node is visited before its parents!
	 * preOrder(v)
	 * 	visit(v);
	 * 	for(Node m : children(v))
	 * 		visit(m)
	 * 
	 * Using snapshot technique instead of lazy iterator!
	 */
	public Iterable<Node<E>> preOrder(Node<E> v) {
		 List<Node<E>> snapshot = new LinkedList< >();//using linked-list b/c for add()/remove() operations it has O(1) time.	 
		 return preOrderHelper(snapshot, v);
	}
	private Iterable<Node<E>> preOrderHelper(List<Node<E>> snapshot, Node<E> v){
		snapshot.add(v);
		for(Node<E> n : children(v))
			preOrderHelper(snapshot,n);
		return snapshot;
	}
	/**
	 * A node is visited after it's children
	 * (Left, Right, Root); opp of preOrder
	 * postOrder(v)
	 * for(Node m : children(v))
	 * 	visit(m)
	 * visit(v);
	 */
	public Iterable<Node<E>> postOrder(Node<E> v){
		List<Node<E>> snapshot = new LinkedList< >();
		return postOrderHelper(snapshot,v);
	}
	private Iterable<Node<E>> postOrderHelper(List<Node<E>> snapshot, Node<E> v){
		for(Node<E> n : children(v))
			postOrderHelper(snapshot,n);
		snapshot.add(v);
		return snapshot;
	}
	/**
	 * A node is visited after it's left child but is visited before it's right child.
	 * (Left, Root, Right)
	 * Note: this traversal method is possible for binary tree and not Trees. 
	 * inOrder(v)
	 * 	if(v.hasLeft)
	 * 		visit(v.leftChild)
	 * 	visit(v)
	 * 	if(v.hasRight)
	 * 		visit(v.rightChild)
	 */
	public Iterable<Node<E>> inOrder(Node<E> v){
		List<Node<E>> snapshot = new LinkedList< >();
		return inOrderHelper(snapshot, v);
	}
	private Iterable<Node<E>> inOrderHelper(List<Node<E>> snapshot, Node<E> v){
		if(v.getLeftChild() != null)
			inOrderHelper(snapshot, v.getLeftChild());
		snapshot.add(v);
		if(v.getRightChild() != null)
			inOrderHelper(snapshot,v.getRightChild());
		return snapshot;
	}
	
	//Nested node class
		private class Node<E>{
			//Feilds
			E element;
			Node<E> parent;
			Node<E> left;
			Node<E> right;
			//Constructor
			public Node(E e) {
				this.element = e;
			}
			//Getters
			public E getElement() {
				return this.element;
			}
			public Node<E> getParent(){
				return this.parent;
			}
			public Node<E> getLeftChild(){
				return this.left;
			}
			public Node<E> getRightChild(){
				return this.right;
			}
			//Setters
			public void setElement(E newE) {
				this.element = newE;
			}
			public void setLeft(Node<E> newL) {
				this.left = newL;
			}
			public void setRight(Node<E> newR) {
				this.right = newR; 
			}
		}
		
		/**
		 * Using snapshot technique as oppose to lazy iterator to return an Iterable collection for usage later.
		 * A reason for using Iterable collection rather than a primitive array is because we can use the for-each loop syntax on our collection!
		 * 
		 * @param n parent node
		 * @return Iterable collection of immediate left and right children 
		 */
		public Iterable<Node<E>> children(Node<E> n){
			List<Node<E>> snapshot = new ArrayList< >();
			if(n.getLeftChild() != null)
				snapshot.add(n.getLeftChild());
			if(n.getRightChild() != null)
				snapshot.add(n.getRightChild());
			return snapshot;
		}
		Node<E> dummyRoot; //dummy root for the purpose of demonstrating Depth and Height algorithms.
		
		/**
		 * Depth of a Node x is equal to the length of the simple path from Root node to x.
		 * In simpler terms,
		 * 1)Depth of Node x = no of ancestors of x, excluding x.
		 * 2)We perform BOTTOM-UP recursive traversal till we reach root node.
		 * 3) Base case: if x is root then depth of x = 0. Recursive case: Else, depth of node x is equal to ONE plus the depth of x's parent.
		 * 
		 * @param x Node whose depth is to be determined.
		 * @return depth of x
		 */
		public int depth(Node<E> x) {
			if(x.equals(dummyRoot)) //Base case
				return 0;
			else {//Recursive case
				return 1 + depth(x.getParent());
			}
		}
		/**
		 * Height of a Node x is equal to number of edges on the LONGEST simple path from x to any leaf.
		 * In simpler terms,
		 * 1)Height of Node x is max depth of any leaf in the tree.
		 * 2)We perform TOP-DOWN recursive traversal till we reach a leaf.
		 * 3)Base case: if x is leaf then height of x is 0. Recursive case: Else, height of x is equal to one plus the maximum of the heights' of x's children.
		 * 
		 * @param x Node whose height is to be determined. 
		 * @return height of x
		 */
		public int height(Node<E> x) {
			int h = 0;
			//No need to explicitly state base case since the for-loop represents the recursive case 
			//and if the for-loop does not execute, i.e. node on current iteration does not have children thus we trigger base case since only leafs dont have children
			for(Node<E> c : children(x))
				h = h + Math.max(h, 1 + height(c)); //Recursive case: If x is not leaf then height of x is equal to one plus the maximum of the heights of x's children.
			return h;
		}
		
}
