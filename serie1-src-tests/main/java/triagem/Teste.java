package triagem;

import java.io.IOException;

public class Teste {

	public static <E> void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashKeyExtractor<Utente>  hash = new HashKeyExtractor<Utente>();
		KeyExtractor<Utente> table = hash.getDefaultInstance();
		Hospital<Utente, Prioridade> h = new Hospital<Utente, Prioridade>(1000,17);
		Utente u1 = new Utente(35392,"João Rodrigues");
		Utente u2 = new Utente(35466,"Nick qualquer coisa");
		Prioridade p1 = new Prioridade("Vermelho");
		Prioridade p2 = new Prioridade("Verde");
//		UtentePrioridade utenPrio1 = new UtentePrioridade(u1, p1, hash.getDefaultInstance().getKey(u1));
//		UtentePrioridade utenPrio2 = new UtentePrioridade(u2, p2, hash.getDefaultInstance().getKey(u2));
		hash.getDefaultInstance();
		h.add(u1, p1, table);
		h.add(u2, p2, table);
//		IO.criaFicheiro("ola.txt");
//		IO.importar(h, "Utentes.txt",hash);
		System.out.println("ok");
	}

}
