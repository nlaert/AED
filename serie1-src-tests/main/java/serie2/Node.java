package serie2;

public class Node<E> {
	public Node<E> previous;
	public Node<E> next;
	public E value;
	
	public Node(){
		value=null;
		next=null;
		previous=null;
	}

	public Node(E i) {
		value=i;
		next=null;
		previous=null;
	}
}
