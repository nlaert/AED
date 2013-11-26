package triagem;

import java.io.IOException;

public class Teste {

	@SuppressWarnings("rawtypes")
	public static <E> void main(String[] args) throws IOException {
//		IO.criaFicheiro("Utentes.txt");
		
		HashKeyExtractor<Utente>  hash = new HashKeyExtractor<Utente>();
		Comparator  cmp = new Comparator();
		//KeyExtractor<Utente> table = hash.getDefaultInstance();
		Hospital<Utente, Prioridade> h = new Hospital<Utente, Prioridade>(10000,17, cmp);
//		Utente u1 = new Utente(35392,"Jo�o Rodrigues");
//		Utente u2 = new Utente(35466,"Nick Laert");
//		Prioridade p1 = new Prioridade("Vermelho");
//		Prioridade p2 = new Prioridade("Vermelho",2);
//		UtentePrioridade utenPrio1 = new UtentePrioridade(u1, p1, hash.getDefaultInstance().getKey(u1));
//		UtentePrioridade utenPrio2 = new UtentePrioridade(u2, p2, hash.getDefaultInstance().getKey(u2));
		hash.getDefaultInstance();
//		h.add(u1, p1, hash);
//		h.add(u2, p2, hash);
		//IO.criaFicheiro("Utentes.txt");
		IO.importar(h, "Utentes.txt",hash);
		Utente x = h.pick();
		x = h.poll();
		h.add(new Utente(35392,"ENGENHEIRO"), new Prioridade("Vermelho",1), hash);
		x = h.pick();
		//h.remove(x.getKey(x.getNumeroUtente()));
		System.out.println(x.getNome() + " " + x.getNumeroUtente());
		System.out.println("ok");
	}

}
