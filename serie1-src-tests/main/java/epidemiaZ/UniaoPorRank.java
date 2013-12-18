package epidemiaZ;


public class UniaoPorRank 
{
	
	
	private int id[], rank[];

	public UniaoPorRank(int N)
	{
		id = new int[N]; 
		rank = new int[N];
		for(int i=0; i<N; i++)
		{ 
			id[i]=i; 
			rank[i]=0; 
		}
	}
	private int root(int x)
	{
		while(x!=id[x])
		{
			id[x]=id[id[x]];
			x=id[x]; 
		}
		return x;


	}
	public boolean procura(int p, int q)
	{ 
		return id[p]==id[q];
	}

	public void uniao(int p, int q)
	{
		int i=root(p), j=root(q);
		if(i==j) 
			return;
		
		if(rank[i]<rank[j]) 
		
			id[i] = j;
		
		else
		{
			if(rank[i]>rank[j]) 
			
				id[j]=i;
			
			else 
			{
			
				id[i]=j; 
				rank[j]+=1;
			}
			
			
		}
		
		
	￼￼}
}
