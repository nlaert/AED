package triagem;


import serie2.Node;

public class Hospital<E,P> extends PriorityQueue<E,P> {
	
	private int utentes = 0;
	private int size ;
	private int m;
	private UtentePrioridade[] array;
	
	public Hospital (int size, int m)
	{
		super(m);
		this.size = size;
		this.m = m;
		array = new UtentePrioridade[size];
	}
	
	
	@Override
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator) {
		super.add(elem, prio, keyExtrator);
		UtentePrioridade aux = new UtentePrioridade((Utente)elem, (Prioridade)prio, keyExtrator.getKey(elem)%m);
		int cor = aux.getPrioridade().corToInt();
		array[utentes++] = aux;
	}
	
	
	

	
	

	public static void HeapSort(UtentePrioridade[] v, int n) {
		  buildHeap(v,n);
		  
	}
	public static void buildHeap(UtentePrioridade[] v,int n){
		  int p= (n >> 1)-1;
		  //int p = parent(n);
		  for ( ; p >=0 ; --p) 
		  {
			  minHeapify(v, p, n);
			  
		  }
	}
	
	
	public static void minHeapify(UtentePrioridade[] v, int p, int hSize) {
		  int l, r, min;
		  l = left(p); 
		  r = right(p);
		  min=p;
		  if(l < hSize &&  v[l].getPrioridade().corToInt() < v[p].getPrioridade().corToInt() ) 
			 min=l;
		  if ( r < hSize && v[r].getPrioridade().corToInt() < v[min].getPrioridade().corToInt() ) 
			 min = r;
		  if ( min == p ) 
			 return;
		  exchange(v, p, min);
		  minHeapify(v, min, hSize); 
		}

	
	
	public static void exchange(UtentePrioridade[] v, int i, int j){
		  UtentePrioridade tmp = v[i];
		  v[i] = v[j];
		  v[j] = tmp;		
		}
	public static int parent(int i ) {
		  return (i-1)>>1;
	}
	public static int left(int i ) { 
		  return (i<<1)+1;
	}
		
	public static int right(int i ) {
		  return (i<<1)+2;
	}

	
	

	
}
