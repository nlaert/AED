package serie3;



public class LNode<E> {
	
	public LNode<E> previous;
	public LNode<E> next;
	public E value;

	public LNode(){
		value=null;
		next=null;
		previous=null;
	}
}

