package triagem;

import java.io.IOException;

public class Teste {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Hospital<Utente, Prioridade> h = new Hospital<Utente, Prioridade>();
		IO.criaFicheiro("ola.txt");
		IO.importar(h, "Utentes.txt");
		System.out.println("ok");
	}

}
