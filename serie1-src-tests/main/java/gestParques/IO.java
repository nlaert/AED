package gestParques;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {


	private static int matriculaSz = 8;
	
	public static void importar(Parque parque, String nomeFicheiro) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
		String line;
		while((line=br.readLine())!=null){
			if(parque.parqueCheio())
				break;
			long reg =Long.parseLong(line.substring(matriculaSz+1));
			parque.novoVeiculo(line.substring(0, matriculaSz), reg);
		}
		br.close();
	}
	
public static  void exportarRegistos(Veiculo[] veiculoRegisto,int nVeiculos, String nomeFicheiro) throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFicheiro));
		for(int i=nVeiculos -1; i>= 0;i--){
			
			bw.write(veiculoRegisto[i].toString());
			bw.newLine();
		}
		bw.close();
		
	}	
	public static  void exportarMatriculas(Veiculo[] veiculoMatricula,int nVeiculos ,String nomeFicheiro) throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFicheiro));
		for(int i=0;i<nVeiculos;i++){
			
			bw.write(veiculoMatricula[i].toString());
			bw.newLine();
		}
		bw.close();
		
	}	
}
