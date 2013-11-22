package triagem;

import serie2.Node;

public class PriorityQueue <E,P> implements KeyExtractor<E> {

	int m = 17;
	Node <E> [] queue = new Node[m];
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void add(E elem, Prioridade prio, KeyExtractor<E> keyExtrator)
	{
		
	}
	
	public E pick()
	{
		return queue[0].next.value;
		
	}
	
	public E poll()
	{
		
		return null;
	}
	
	public void update (int key, Prioridade prio)
	{
		
	}
	
	public void remove (int key)
	{
		
	}

	@Override
	public int getKey(E e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
