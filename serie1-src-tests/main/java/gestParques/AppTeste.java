package gestParques;

import java.io.IOException;

import gestParques.IO;
import gestParques.Parque;
import gestParques.Veiculo;


public class AppTeste {

	public static void main(String[] args) throws IOException
	{
		int m = 10000;
		int m2 = 20000;
		Parque gestao;
		Parque gestao1;
		
		long inicio, fim, dif;
		//for(int i = 0; i< 10;i++){
			gestao =  new Parque(m);
			inicio = System.currentTimeMillis();
			IO.importar(gestao,"aed-serie1-plates.txt");
			fim = System.currentTimeMillis();
			dif = fim - inicio;
			System.out.println(dif);
			gestao = null;
			gestao =  new Parque(m2);
			inicio = System.currentTimeMillis();
			IO.importar(gestao,"aed-serie1-plates.txt");
			fim = System.currentTimeMillis();
			dif = fim - inicio;
			System.out.println(dif);
			
		//}
		

		
		
	}
}
