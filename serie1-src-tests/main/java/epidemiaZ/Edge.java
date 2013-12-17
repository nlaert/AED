package epidemiaZ;

public class Edge {

	public int id;
	public Edge next;
	private int predecessor;
	private int distancia;
	
	
	public Edge(int id){
		this.id = id;
		next = null;
	}
	
	public void setPredecessor(int predecessor)
	{
		this.predecessor = predecessor;
	}
	
	public void setDistancia(int distancia)
	{
		this.distancia = distancia;
	}
}
