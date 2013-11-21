package gestParques;

public class Parque {
	
	
	private Veiculo [] veiculos;
	private int nVeiculos;
	private int size;
	
	public Parque(int m){
		veiculos = new Veiculo[m];
		nVeiculos = 0;
		size = m;
	}
	
	public boolean matriculaValida(String matricula) {
		matricula = matricula.toUpperCase();
		for(int i = 0; i<matricula.length()-1;i++)
		{
			if( i <2)
			{
				if(!(matricula.charAt(i) >= '0' && matricula.charAt(i) <='9' ))
					return false;
			}
			if(i == 2 || i == 5)
			{
				 if(!(matricula.charAt(i) == '-'))
						return false;
			}
			if(i>2 && i!= 5)
			{
				if(!(Character.isLetterOrDigit(matricula.charAt(i))))
					return false;
			}
			
		}
		return true;
		
	}
	
	public boolean novoVeiculo(String matricula)
		{
			return novoVeiculo(matricula,System.currentTimeMillis());
		}
	
	
	public boolean novoVeiculo(String matricula, long registo){
		if(!parqueCheio() && matriculaValida(matricula)){
			veiculos[nVeiculos] = new Veiculo(matricula,registo);
			nVeiculos++;
			decreaseKey(veiculos,nVeiculos-1);
			return true;
		}

		return false;
	}
	
	
	
	
	public boolean parqueCheio()
	{
		return nVeiculos == size;
	}
	
	
	
	public boolean removeVeiculo(String matricula){
		int i = procuraVeiculo(matricula);
		if(i==-1)
			return false;
		Veiculo old = veiculos[i];
		exchange(veiculos, i, nVeiculos-1);
		
		veiculos[--nVeiculos] = null;
		if(i < nVeiculos){ // se tiver no ultimo nó
			if(old.getRegisto() > veiculos[i].getRegisto())
				decreaseKey(veiculos,i);
			else
				minHeapify(veiculos, i, nVeiculos);
		}
		
			
		return true;
	}

	static void decreaseKey(Veiculo [] v, int i ) {
	
		while(i>0 && v[i].getRegisto()<v[parent(i)].getRegisto()){
			exchange(v, i, parent(i));
			i = parent(i);
		}
}

	
	public int procuraVeiculo(String matricula) {
		
		
		for(int i = 0; i< nVeiculos; i++)
		{
			if(veiculos[i].getMatricula().equals(matricula))
				return i;
		}
		return -1;
	}
	
	
	public Veiculo getVeiculo(int i)
	{
		return veiculos[i];
	}
	
	public int getNVeiculos() {
		
		return nVeiculos;
	}

	public String maisAntigo() {
		//HeapSort(veiculos, nVeiculos);
		return veiculos[0].getMatricula();
	}
	public Veiculo[] ordenadoPorTempo()
	{
		Veiculo[] array=new Veiculo[nVeiculos];
		System.arraycopy(veiculos, 0, array, 0, nVeiculos);
		for ( int i=nVeiculos-1; i> 0; --i) {
			  exchange(array, 0, i);
			  minHeapify(array, 0, i);

		   }
		return array;
	}
	//correcto
	public  Veiculo [] ordenarMatriculas()
	{
		Veiculo [] aux = veiculos;
		Veiculo [] temp = new Veiculo[veiculos.length];
		int N = nVeiculos;
		for (int d = 7; d >=0; d--)
		{
			if(d!=5 && d!=2)
			{
				int[] count = new int[92];
				for (int i = 0; i < N; i++)
					count[aux[i].getMatricula().charAt(d)]++;
				for (int k = 1; k < 92; k++)
					count[k] += count[k-1];
				for (int i = N-1; i >=0; i--){
					temp[count[aux[i].getMatricula().charAt(d)]-1] = aux[i];
					count[aux[i].getMatricula().charAt(d)]--;
				}
				for (int i = N-1; i >= 0; i--)
					aux[i] = temp[i];
			}
		}
		return aux;


	}
	
	public static void HeapSort(Veiculo[] v, int n) {
		  buildHeap(v,n);
		  
	}
	public static void buildHeap(Veiculo[] v,int n){
		  int p= (n >> 1)-1;
		  //int p = parent(n);
		  for ( ; p >=0 ; --p) 
		  {
			  minHeapify(v, p, n);
			  
		  }
	}
	
	
	public static void minHeapify(Veiculo [] v, int p, int hSize) {
		  int l, r, min;
		  l = left(p); 
		  r = right(p);
		  min=p;
		  if(l < hSize &&  v[l].getRegisto() < v[p].getRegisto() ) 
			 min=l;
		  if ( r < hSize && v[r].getRegisto() < v[min].getRegisto() ) 
			 min = r;
		  if ( min == p ) 
			 return;
		  exchange(v, p, min);
		  minHeapify(v, min, hSize); 
		}

	
	
	public static void exchange(Veiculo[] v, int i, int j){
		  Veiculo tmp = v[i];
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
