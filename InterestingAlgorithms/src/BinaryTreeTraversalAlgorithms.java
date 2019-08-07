/**
 * 
 */

/**
 * @author sid16
 *
 */
										//added this for Generics suppourt
public class BinaryTreeTraversalAlgorithms<E> {
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
	public Iterable<Node<E>> preOrder(Node<E> v) {
		/**
		 * (Root, Left, Right)
		 * Node is visited before its parents!
		 * preOrder(v)
		 * 	visit(v);
		 * 	for(Node m : children(v))
		 * 		visit(m)
		 */
	}
	public Iterable<Node<E>> postOrder(Node<E> v){
		/**
		 * Node is visited after it's children
		 * (Left, Right, Root); opp of preOrder
		 * postOrder(v)
		 * for(Node m : children(v))
		 * 	visit(m)
		 * visit(v);
		 */
	}
	public Iterable<Node<E>> inOrder(Node<E> v){
		/**
		 * This traversal method is possible for binary tree and not Trees. 
		 * (Left, Root, Right)
		 * inOrder(v)
		 * 	if(v.hasLeft)
		 * 		visit(v.leftChild)
		 * 	visit(v)
		 * 	if(v.hasRight)
		 * 		visit(v.rightChild)
		 */
	}
}
