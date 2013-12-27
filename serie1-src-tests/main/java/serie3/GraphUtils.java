package serie3;

public class GraphUtils {

	public static int numberOfNeighoursAtDistanceN(Vertex[] graph, int verticeId, int n){
		if (n<0)
			return 0;
		Queue<Vertex> queue = new Queue<Vertex>();
		boolean visited [] = new boolean[graph.length], decrement;
		int count=0, id;
		queue.enqueue(graph[verticeId]);
		visited[verticeId] = true;
		Edge edgeAux;
		while(n>0){
			decrement = false;
			if(!queue.isEmpty()){
				edgeAux = queue.dequeue().adjacentList.next;
				while(edgeAux!=null){
					id = edgeAux.adjacent.id;
					if(!visited[id]){
						queue.enqueue(graph[id]);
						count++;
						visited[id] = true;
						decrement = true;
					}
					edgeAux = edgeAux.next;
				}
				if(decrement)
					n--;
			}
			else
				break;
		}
		return count;
	}
}
