package triagem;


public class PriorityQueue <E,P>  {

	private int m ;
	Node<E>[] table;
	private HashKeyExtractor<E> hash;
	public PriorityQueue(int m)
	{
		this.m = m;
		table = new Node[m];
		hash = new HashKeyExtractor<>();
		
	}
	public KeyExtractor getKeyExtractor()
	{
		return hash.getDefaultInstance();
	}
	public PriorityQueue()
	{
		this.m = 17;
		table = new Node[m];
	}
	
	
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator)
	{
		insert(elem,keyExtrator);
	}
	
	public E pick()
	{
		//E keyMaiorPrioridade = (E) array[0].getUtente();
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
	
	public static <E> void insert(Node<E> dummy, E newNode) {
		Node <E> aux = new Node<E>(newNode);
		aux.next = dummy.next;
		dummy.next = aux;
	}
	
	public final int index(E e, KeyExtractor<E> keyExtractor){
		int h=keyExtractor.getKey(e) % m;
		return (h<0)?h+m:h;
	}
	public  E search(E key,KeyExtractor<E> keyExtractor){ 
		
		int i = index(key,keyExtractor);
		Node<E> curr = table[i]; 
		while(curr != null){
			int cur = curr.hashCode();
			if(keyExtractor.getKey(key) == curr.value.hashCode()) 
				return curr.value;
			curr = curr.next;
		}
		return null;
	}
	public final void insert(E e,KeyExtractor<E> keyExtractor){
		int i = index(e,keyExtractor);
		Node<E> n = new Node<E>(e);
		n.next = table[i];
		table[i] = n;
	}
	
	public final boolean delete(E e,KeyExtractor<E> keyExtractor){ 
		int i = index(e,keyExtractor);
		Node<E> curr = table[i];
		Node<E> prev = null; 
		while(curr != null){
			if(keyExtractor.getKey(e) == curr.value.hashCode())
			{
				if(prev == null)
				{ 
					table[i] = table[i].next;
				} 
				else{ 
					prev.next = curr.next; 
				} 
				return true;
			}
			prev = curr; 
			curr = curr.next;
		}	
		return false;
	}

	
	
}
