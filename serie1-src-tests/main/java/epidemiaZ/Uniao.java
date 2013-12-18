package epidemiaZ;

public class Uniao {
	
	private int id[], rank[];
	public Uniao (int N)
	{
		id = new int[N]; 
		rank = new int[N];
		for(int i=0; i<N; i++)
		{ 
			id[i]=i; 
			rank[i]=0; 
		}
	}

}
