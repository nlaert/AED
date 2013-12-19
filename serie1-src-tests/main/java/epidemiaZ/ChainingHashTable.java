package epidemiaZ;

public class ChainingHashTable<E>  { 
	
	Node<E>[] v;
	int m;
	KeyExtractor <E> keyExtractor;
	
	public ChainingHashTable(int len){
		this(len,new HashKeyExtractor<E>().getDefaultInstance());
	}
	public ChainingHashTable(int len, KeyExtractor<E> keyExtractor){
		v = new Node[len];
		m = len;
		this.keyExtractor = keyExtractor; 
	}
	
	public final int index(E e){
		int h=keyExtractor.getKey(e) % m;
		return (h<0)?h+m:h;
	}
	public final E search(E key){ 
		
		int i = index(key);
		Node<E> curr = v[i]; 
		while(curr != null){
			if(keyExtractor.getKey(key) == curr.hashCode()) 
				return curr.value;
			curr = curr.next;
		}
		return null;
	}
	public final void insert(E e){
		int i = index(e);
		Node<E> n = new Node<E>(e);
		n.next = v[i];
		v[i] = n;
	}
	
	public final boolean delete(E e){ 
		int i = index(e);
		Node<E> curr = v[i];
		Node<E> prev = null; 
		while(curr != null){
			if(keyExtractor.getKey(e) == curr.hashCode())
			{
				if(prev == null)
				{ 
					v[i] = v[i].next;
				} 
				else{ 
					prev.next = curr.next; 
				} 
				return true;
			}
			prev = curr; curr = curr.next;
		}	
		return false;
	}



}