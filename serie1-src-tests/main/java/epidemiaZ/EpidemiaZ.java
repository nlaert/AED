package epidemiaZ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EpidemiaZ {
	
	private Edge edges[];
	private Individuo individuos[];
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
				size = Integer.parseInt(line);
				edges = new Edge[size];
				individuos = new Individuo[size];
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
		int id = Integer.parseInt(line.substring(0, line.indexOf('\t')))-1;
		line = line.substring(line.indexOf('\t')+1);
		String localidade = line.substring(0, line.indexOf('\t'));
		line = line.substring(line.indexOf('\t')+1);
		char estado = line.charAt(0);
		
		edges[id] = new Edge(id);
		individuos[id] = new Individuo(id,localidade,estado);
		for (int i=2;i<line.length();i+=2){
			insert(id, line.charAt(i)-'0');
		}		
	}

	private void insert(int id, int adjacentId) {
		Edge aux = new Edge(adjacentId);
		aux.next = edges[id].next;
		edges[id].next = aux;		
	}
}
