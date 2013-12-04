package serie3;

public class Node<E> {
	public Node<E> left;
	public Node<E> right;
	public E value;
	
	public Node(){
		value=null;
		right=null;
		left=null;
	}

	public Node(E i) {
		value=i;
		right=null;
		left=null;
	}
}
