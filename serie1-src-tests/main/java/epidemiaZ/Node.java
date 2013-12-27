package epidemiaZ;


public class Node<E> {
	
	public Node<E> next;
	public Node<E> previous;
	public E value;
	

	public Node(E i) {
		value=i;
		previous=null;
		next=null;
	}
	
	public Node()
	{
		value=null;
		previous=null;
		next=null;
	}
}
