package epidemiaZ;


public class UniaoPorRank 
{
	
	
	private int id[];
	private int rank[];
	private int distancia[];
	
	

	public UniaoPorRank(int N)
	{
		id = new int[N]; 
		rank = new int[N];
		distancia = new int[N];
		for(int i=1; i<N; i++)
		{ 
			id[i]=i; 
			rank[i]=0; 
			distancia[i]=-1;
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
	public boolean infected(int idx)
	{ 
		return distancia[idx] != -1;	
	}
	public int getDistancia(int idx)
	{
		return distancia[idx];
	}

	public void uniao(int p, int q, int dist)
	{
		int i=root(p), j=root(q);
		if(i==j) 
			return;
		
		if(rank[i]<rank[j]) 
		{
			id[i] = j;
			distancia[i] = dist;
		}
		else
		{
			if(rank[i]>rank[j]) 
			{
				id[j]=i;
				distancia[j] = dist;
			}
			else 
			{
			
				id[i]=j; 
				rank[j]+=1;
				distancia[j]= 0;
				distancia[i] = dist;
			}
		}
	}
	
}
