package serie3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class numberOfNeighoursAtDistanceNTest {
	
	public static void main(String[] args) throws IOException {
		Vertex [] graph = importar("C:/Users/Nick/Documents/GitHub/main/graphNeighboursTest.txt");
		System.out.println(GraphUtils.numberOfNeighoursAtDistanceN(graph, 0, 3));
	}
	
	private static Vertex[] importar(String nomeFicheiro) throws IOException{
		Vertex[] graph = null;
		BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
		String line;
		int countLine =0;
		while((line=br.readLine())!=null){
			if(countLine==0){
				int size = Integer.parseInt(line);
				graph = new Vertex[size];
				for (int i=0;i<size;i++){
					graph[i] = new Vertex(i);
				}
			}
			else{
				int vId;
				int space = line.indexOf(' ');
				if(space<1)
					vId = Integer.parseInt(line.substring(0));
				else
					vId = Integer.parseInt(line.substring(0, space));
				line = line.substring(space+1);
				//graph[vId] = new Vertex(vId);
				//graph[vId].adjacentList = new Edge();
				
				while(line.length()>=1){
					space = line.indexOf(' ');
					int id;
					if(space<1){
						id = Integer.parseInt(line.substring(0));
						line = "";
					}
					else{
						id = Integer.parseInt(line.substring(0, space));
						line = line.substring(space+1);
					}
					Edge aux = new Edge();
					aux.adjacent = graph[id];
					insert(graph[vId].adjacentList, aux);
				}
			}
			countLine++;
		}
		br.close();
		return graph;
	}
	
	private static void insert(Edge root , Edge newEdge) {
		
		newEdge.next = root.next;
		root.next = newEdge;	
		
	}
}
