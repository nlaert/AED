package triagem;

import serie2.Node;

public class PriorityQueue <E,P>  {

	private int m = 17;
	private int size = 0;
	
	private Node <E> [] queue = new Node[m];
	
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator)
	{
		insert(queue[keyExtrator.getKey(elem)], elem);
		
	}
	
	public E pick()
	{
		return null;
		
	}
	
	public E poll()
	{
		
		return null;
	}
	
	public void update (int key, P prio)
	{
		
	}
	
	public void remove (int key)
	{
		
	}
	
	private static <E> void insert(Node<E> dummy, E newNode) {
		Node <E> aux = new Node<E>(newNode);
		aux.next = dummy.next;
		dummy.next = aux;
	}

	
	
}
