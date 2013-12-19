package epidemiaZ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import serie3.Queue;

public class EpidemiaZ {
	
	private Edge[] edges;
	private Individuo[] individuos;
	private Edge infectados;
	private String data;
	private UniaoPorRank union;
	private int size;
	public ChainingHashTable<CidadeInfectada> hash;
	private final int hashSize = 7;
	
	public EpidemiaZ(String nomeFicheiro) throws IOException{
		hash = new ChainingHashTable<>(hashSize);
		importar(nomeFicheiro);
		epidemia();
	}
	
	

	private void importar(String nomeFicheiro) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
		String line;
		int countLine =0;
		while((line=br.readLine())!=null){
			if(countLine==0){
				size = Integer.parseInt(line) +1;
				edges = new Edge[size];
				individuos = new Individuo[size];
				union = new UniaoPorRank(size);
				
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
		CidadeInfectada ci = new CidadeInfectada(localidade);
		if(hash.search(ci) == null)
		{
			hash.insert(ci);
		}
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
	
	public void epidemia(){
		while(infectados != null){
			BFS(infectados.id);
			infectados = infectados.next;
		}
			
		
	}
	
	
	public void BFS(int idx)
	{
		Edge curr;
		Edge v;
		
		for(int i = 1; i< edges.length; i++)
		{
			edges[i].setPredecessor(-1);
			edges[i].setDistancia(-1);
		}
		edges[idx].setDistancia(0);
		CidadeInfectada ci = new CidadeInfectada(individuos[idx].getLocalidade());
		hash.search(ci).setDias(0);
		Queue <Edge> queue = new Queue<Edge>();
		queue.enqueue(edges[idx]);
		while(!queue.isEmpty())
		{
			curr = queue.dequeue(); //inicio
		
			v = edges[curr.id]; // proximo
			while( v.next != null)
			{
				v = v.next;
				if(edges[v.id].getDistancia() == -1)
				{
					edges[v.id].setDistancia(edges[curr.id].getDistancia()+1);
					edges[v.id].setPredecessor(curr.id);
					
					if(individuos[v.id].getEstado() != 'R')
					{
						queue.enqueue(v);
						union.uniao(v.id, curr.id,edges[v.id].getDistancia());
						ci = new CidadeInfectada(individuos[v.id].getLocalidade());
						if(hash.search(ci).getDias() == -1)
						{
							hash.search(ci).setDias(edges[v.id].getDistancia());
						}
						else if(hash.search(ci).getDias() > union.getDistancia(v.id))
							hash.search(ci).setDias(union.getDistancia(v.id));
						
					}
					
					
				}
			}
		}
		
	}
	
	public boolean becomeInfected(int idx)
	{
		return union.infected(idx);
	}
	
	public void becomeInfected()
	{
		int count = 0;
		for(int i = 1; i<size;i++)
		{
			if(becomeInfected(i)){
				count++;
				System.out.println(i);
			}
		}
		System.out.println("Total: "+count);
	}
	public void becomeInfectedAfterXDays(int idx)
	{
		int count = 0;
		for(int i =1;i<size;i++)
		{
			if(union.getDistancia(i)<=idx && union.getDistancia(i)> -1)
			{
				System.out.println(i);
				count++;
			}
		}
		System.out.println("Total: "+count);
	}
	
	public void riskAreas(int x)
	{
		for(int i=0; i<hashSize;i++)
		{
			Node<CidadeInfectada> curr = hash.getRow(i);
			while(curr != null)
			{
				if(curr.value.getDias() <= x && curr.value.getDias() > -1)
					System.out.println(curr.value.getNome() + "(RISK)");
				else
					System.out.println(curr.value.getNome() + "(NOT in RISK)");
				curr = curr.next;
			}
		}
	}

}
