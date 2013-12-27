package serie3;

public class Vertex {

	public int id;
	public Edge adjacentList;
	
	public Vertex(int id){
		this.id = id;
		adjacentList = new Edge();
	}
}
