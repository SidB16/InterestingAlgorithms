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
}
