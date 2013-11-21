package serie1;

public class Arrays{
	
	public static int countInRange(int[] v1, int l, int r, int min, int max){
		if (l>=r)
			return 0;
		return upperBound(v1, l, r, max) - lowerBound(v1, l, r, min) +1;
	}
	
	private static int lowerBound(int[] v1, int l, int r, int min){
		int mid=0;
		while(l<=r){
			mid = l+(r-l)/2;
			if(v1[mid]>=min)
				r=mid-1;
			else
				l=mid+1;
		}
		return l;
	}
	
	private static int upperBound(int[] v1, int l, int r, int max){
		int mid=0;
		while(l<=r){
			mid = l+(r-l)/2;
			if(v1[mid]<=max)
				l=mid+1;
			else
				r=mid-1;
		}
		return r;
	}
	
	public static int removeIndexes(int v[], int l, int r, int[] v1, int li, int ri) {

			if (v.length == 0 || l > r)			
				return 0;						
			if (v1.length == 0 || li > ri)		
				return r - l + 1;				
			if ((v1[ri] < l))					
				return r - l + 1;				
			int i = l; 			
			int j = li;		
			int len = 0, equals = 0;			

			while (v1[j] < i)					
				j++;							

			for (; i < r + 1; i++) {			
				if (j <= ri && i == v1[j]) {	
					j++;						
					equals++;					
				} else {						
					v[len + l] = v[i];			
					len++;						
				}
			}
			return r - l + 1 - equals;
	}	
	
	public static int removeFromMaxHeap(int[] maxHeap, int count, int ix){
		if(ix >= count)
			throw  new IllegalArgumentException();
		exchange(maxHeap,ix,--count);
		if(maxHeap[ix] > maxHeap[count])
			increaseKey(maxHeap,count,ix);
		else
			heapify(maxHeap, ix, count);
		return maxHeap[count];
	}
	public static void heapify(int[] v, int p, int hSize) {
		  int l, r, largest;
		  l = left(p); 
		  r = right(p);
		  largest=p;
		  if(l < hSize &&  v[l] > v[p]) 
			 largest=l;
		  if ( r < hSize && v[r] > v[largest]) 
			 largest = r;
		  if ( largest == p ) 
			 return;
		  exchange(v, p, largest);
		  heapify(v, largest, hSize); 
		}

	
	
	public static void exchange(int[] v, int i, int j){
		  int tmp = v[i];
		  v[i] = v[j];
		  v[j] = tmp;		
		}
	public static void increaseKey(int [] v, int size, int pos)
	{
		int pai = parent(pos);
		while(pai >=0 && v[pai] < v[pos])
		{
			exchange(v,pai, pos);
			pos = pai;
			pai = parent(pos);
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



	
	public static int median(int[] v, int l, int r){
		//Pode-se assumir que v tem sempre valores?
		if (l==r)
			return v[l];
		quickSort(v,l,r);
		int mid = (r+l)/2;
		if ((r-l+1)%2==0)
			return (v[mid] + v[mid+1])/2;
		return v[mid];

	}
	
	public static void quickSort(int a[], int left, int right){
		int i;
		if (right <= left) return;
		i = partition(a, left, right);
		quickSort(a, left, i-1);
		quickSort(a, i+1, right);
	} 
	public static int partition(int[] a, int l, int r){
		int x=a[r];
		int i=l-1;
		for(int j=l; j<r;j++){
			if(a[j]<=x){
				i++;
				exchange(a,i,j);
			}
		}
		i++;
		exchange(a,r,i);
		return i;
	}



}
