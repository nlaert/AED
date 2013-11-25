package triagem;


public class PriorityQueue <E,P>  {

	private int m ;
	private ChainingHashTable<E> table;
	public PriorityQueue(int m)
	{
		this.m = m;
		table = new ChainingHashTable<>(m);
		
	}
	
	public PriorityQueue()
	{
		this.m = 17;
	}
	
	
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator)
	{
		table.insert(elem);
		
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
	
	protected static <E> void insert(Node<E> dummy, E newNode) {
		Node <E> aux = new Node<E>(newNode);
		aux.next = dummy.next;
		dummy.next = aux;
	}

	
	
}
