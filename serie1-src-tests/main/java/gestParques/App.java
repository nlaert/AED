package gestParques;



import java.io.IOException;
import java.util.Scanner;

import gestParques.IO;
import gestParques.Parque;


public class App {

	public static void main(String [] args) throws IOException
	{
		//int m = Integer.parseInt(args[0]);
		int m = 250000;
		Parque gestao = new Parque(m);
		@SuppressWarnings("resource")
		Scanner k = new Scanner(System.in);
		while(true)
		{
			mostraMenu();
			String op = k.nextLine();
			if(op.contains("entrada")){
				if(!gestao.novoVeiculo(op.substring(op.indexOf(' ')+1)))
					System.out.println("Parque Cheio ou erro na matricula");
			}
			else if(op.contains("saida")){
				if(!gestao.removeVeiculo(op.substring(op.indexOf(' ')+1)))
					System.out.println("Matricula não existe");
			}
			else if(op.equals("maisAntigo"))
				System.out.println(gestao.maisAntigo());
			else if(op.contains("exportar")){
				if(op.contains("registo"))
				{
					IO.exportarRegistos(gestao.ordenadoPorTempo(),gestao.getNVeiculos() ,getNomeFicheiro(op));
				}
					
				else{
					IO.exportarMatriculas(gestao.ordenarMatriculas(),gestao.getNVeiculos(), getNomeFicheiro(op));
				}
					
				
			}
			else if(op.contains("importar")){
				if(op.contains("novo"))
					gestao = new Parque(m);
				IO.importar(gestao,getNomeFicheiro(op));
			}
		}
		

	}
	
	private static void mostraMenu(){
		System.out.println("1 - entrada <matricula>");
		System.out.println("2 - saida <matricula>");
		System.out.println("3 - maisAntigo");
		System.out.println("4 - exportar [registo|matricula] <ficheiro>");
		System.out.println("5 - importar [mais|novo] <ficheiro>");
	}
	
	private static String getNomeFicheiro(String str){
		return str.substring(str.lastIndexOf(' ')+1);
		
		
	}
}
