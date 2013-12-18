package epidemiaZ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import serie3.Queue;

public class EpidemiaZ {
	
	private Edge[] edges;
	private Individuo[] individuos;
	private Connection[] conjuntos;
	private Edge infectados;
	private String data;
	
	public EpidemiaZ(String nomeFicheiro) throws IOException{
		importar(nomeFicheiro);
	}

	private void importar(String nomeFicheiro) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
		String line;
		int countLine =0, size;
		while((line=br.readLine())!=null){
			if(countLine==0){
				size = Integer.parseInt(line) +1;
				edges = new Edge[size];
				individuos = new Individuo[size];
				conjuntos = new Connection[size];
			}
			else if(countLine==1)
				data = line;
			else
				add(line);
			countLine++;
		}
		br.close();
	}

	private void add(String line) {
		int id = Integer.parseInt(line.substring(0, line.indexOf('\t')));
		line = line.substring(line.indexOf('\t')+1);
		String localidade = line.substring(0, line.indexOf('\t'));
		line = line.substring(line.indexOf('\t')+1);
		char estado = line.charAt(0);
		line = line.substring(line.indexOf('\t')+1);
		
		edges[id] = new Edge(id);
		individuos[id] = new Individuo(id,localidade,estado);
		if(estado == 'I')
		{
			if(infectados == null)
				infectados = new Edge(id);
			else{
				insert(infectados,id);
			}
				
		}
			
		while(!line.equals(""))
		{
			int indexOf = line.indexOf('\t')+1, aux;
			if(indexOf<=0){
				aux = Integer.parseInt(line.substring(0));
				line = "";
			}
				
			else{
				aux = Integer.parseInt(line.substring(0, indexOf-1));
				line = line.substring(indexOf);
			}
			
			insert(edges[id], aux);
		}		
	}


	private void insert(Edge e , int adjacentId) {
		Edge aux = new Edge(adjacentId);
		aux.next = e.next;
		e.next = aux;		
	}
	
	public boolean BST(int idx)
	{
		Edge aux;
		Edge v;
		for(int i = 1; i< edges.length; i++)
		{
			edges[i].setPredecessor(-1);
			edges[i].setDistancia(-1);
		}
		edges[idx].setDistancia(0);
		Queue <Edge> queue = new Queue<Edge>();
		queue.enqueue(edges[idx]);
		while(!queue.isEmpty())
		{
			aux = queue.dequeue();
			if(individuos[aux.id].getEstado() == 'I')
			{
				return true;
			}
			v = edges[aux.id];
			while( v.next != null)
			{
				v = v.next;
				if(edges[v.id].getDistancia() == -1)
				{
					if(individuos[v.id].getEstado() == 'I')
					{
						return true;
					}
					edges[v.id].setDistancia(aux.getDistancia()+1);
					edges[v.id].setPredecessor(aux.id);
					
					if(individuos[v.id].getEstado() != 'R')
					{
						queue.enqueue(v);
					}
					
				}
			}
		}
		
		return false;
	}
	public boolean becomeInfected(int id)
	{
		return BST(id);
	}
}
