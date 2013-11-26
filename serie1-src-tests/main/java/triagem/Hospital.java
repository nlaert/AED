package triagem;

public class Hospital<E,P> extends PriorityQueue<E,P> {
	
	private int utentes = 0;
	private int size ;
	private int m;
	private UtentePrioridade[] array;
	private Comparator cmp;
	
	public Hospital (int size, int m, Comparator cmp)
	{
		super(m);
		this.size = size;
		this.m = m;
		array = new UtentePrioridade[size];
		this.cmp = cmp;
	}
	
	
	@Override
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator) {
		super.add(elem, prio, keyExtrator);
		
		UtentePrioridade aux = new UtentePrioridade((Utente)elem, (Prioridade)prio, keyExtrator.getKey(elem));
		
		array[utentes] = aux;
		utentes++;
		decreaseKey(array, utentes-1,cmp);
	}
	
	@Override
	public E pick()
	{
		E keyMaiorPrioridade = (E) array[0].getUtente();
		//return super.search(keyMaiorPrioridade, getKeyExtractor());
		return keyMaiorPrioridade;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public E poll()
	{
		E keyMaiorPrioridade = (E) array[0].getUtente();
		super.delete(keyMaiorPrioridade, getKeyExtractor());
		removeFromHeap(array[0].getKey());
		return keyMaiorPrioridade;
	}
	
	@Override
	public void remove(int key){
		for(int i = 0;i<utentes;i++)
		{
			if(array[i].getKey() == key)
			{
				super.delete((E)array[i].getUtente(), getKeyExtractor());
				removeFromHeap(key,i);
				break;
			}
				
		}
		
	}
	
	@Override
	public void update(int key, P prio) {
		for(int i = 0;i<utentes;i++)
		{
			if(array[i].getKey() == key)
			{
				super.search((E)array[i].getUtente(), getKeyExtractor());
				array[i].setPrioridade((Prioridade)prio);
				minHeapify(array, i, utentes, cmp);
				break;
			}
				
		}
		
	}
	public void removeFromHeap(int key)
	{
		removeFromHeap(key, -1);
	}
	
	public void removeFromHeap(int key,int indice) {
		int i=0;
		if(indice == -1)
		{
			for (;i<utentes;i++){
				if(array[i].getUtente().getNumeroUtente() == key)
					break;
			}
		}
		else	i=indice;
		
		
		UtentePrioridade old = array[i];
		exchange(array,i,utentes-1);
		array[--utentes] = null;
		if (i<utentes){
			UtentePrioridade n = array[i];
			long aux =  cmp.compare(old.getPrioridade(), n.getPrioridade());
			if(aux<0)
				decreaseKey(array, i, cmp);
			else
				minHeapify(array, i, utentes,cmp);
				
		}
		
	}


	
	
	public static void minHeapify(UtentePrioridade[] v, int p, int hSize,Comparator cmp) {
		  int l, r, min;
		  l = left(p); 
		  r = right(p);
		  min=p;
		 // if(l < hSize &&  v[l].getPrioridade().corToInt() < v[p].getPrioridade().corToInt() ) 
		  if(l < hSize &&  cmp.compare(v[l].getPrioridade(), v[p].getPrioridade()) >= 0 ) 
			 min=l;
		  //if ( r < hSize && v[r].getPrioridade().corToInt() < v[min].getPrioridade().corToInt() ) 
		  if ( r < hSize && cmp.compare(v[r].getPrioridade(), v[min].getPrioridade()) >= 0) 
			 min = r;
		  if ( min == p ) 
			 return;
		  exchange(v, p, min);
		  minHeapify(v, min, hSize,cmp); 
		}

	
	
	public static void exchange(UtentePrioridade[] v, int i, int j){
		  UtentePrioridade tmp = v[i];
		  v[i] = v[j];
		  v[j] = tmp;		
	}
	
	public static void decreaseKey(UtentePrioridade [] v, int i ,Comparator cmp) {
		
		while(i>0 && cmp.compare(v[i].getPrioridade(), v[parent(i)].getPrioridade()) >= 0){
		//while(i>0 && v[i].getPrioridade().corToInt()<v[parent(i)].getPrioridade().corToInt()){
			exchange(v, i, parent(i));
			i = parent(i);
		}
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
	
	public boolean hospitalCheio(){
		return utentes == size;
	}

	
	

	
}
