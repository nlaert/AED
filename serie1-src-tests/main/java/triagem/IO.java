package triagem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {


	
	
	public static <E> void importar(Hospital<Utente, Prioridade> hospital, String nomeFicheiro, KeyExtractor<Utente> keyExtractor) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
		String line;
		while((line=br.readLine())!=null){
			UtentePrioridade aux = getUtentePrioridade(line);
			hospital.add(aux.getUtente(),aux.getPrioridade(), keyExtractor);
		}
		br.close();
	}
	
	public static UtentePrioridade getUtentePrioridade(String line){
		int aux;
		aux = line.indexOf(';');
		int nUtente = Integer.parseInt(line.substring(0,aux));
		line = line.substring(aux+2);
		aux = line.indexOf(';');
		String nome = line.substring(0,aux);
		line = line.substring(aux+2);
		
		aux = line.indexOf(';');
		String cor = line.substring(0,aux);
		line = line.substring(aux+2);
		long ad = Long.parseLong(line);
		Prioridade p;
		if (ad<=0)
			p = new Prioridade(cor);
		else
			p = new Prioridade(cor,ad);
		return new UtentePrioridade(new Utente(nUtente,nome),p,0);		
	}
	
	static String[] nomes = {"Joao ","Nick ", "Bruno ", "Ricardo ", "Miguel ", "Jose "};
	static String [] apelidos = {"Delgado", "Cardoso", "Neves", "Carvalho", "Costa"};
	static String [] cores = {"vermelho", "laranja", "amarelo", "verde", "azul"};
	public static void criaFicheiro(String nomeFicheiro, int size) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFicheiro));
		for (int i=0;i<size;i++){
			int n = (int)(Math.random() * (6 - 0) + 0);
			int a = (int)(Math.random() * (5 - 0) + 0);
			int c = (int)(Math.random() * (5 - 0) + 0);
			bw.write(i + "; " + nomes[n] + apelidos[a] + "; " + cores[c] + "; " + System.currentTimeMillis());
			bw.newLine();
		}
		bw.close();
	}
	
	
	
//public static  void exportarRegistos(Veiculo[] veiculoRegisto,int nVeiculos, String nomeFicheiro) throws IOException{
//		
//		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFicheiro));
//		for(int i=nVeiculos -1; i>= 0;i--){
//			
//			bw.write(veiculoRegisto[i].toString());
//			bw.newLine();
//		}
//		bw.close();
//		
//	}	
}
