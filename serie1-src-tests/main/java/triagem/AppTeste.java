package triagem;

import java.io.IOException;

public class AppTeste {

	public static void main(String[] args) throws IOException {
		int size = 100000;
		//IO.criaFicheiro(size+"Utentes", size);
		HashKeyExtractor<Utente>  hash = new HashKeyExtractor<Utente>();
		Comparator  cmp = new Comparator();
		Hospital<Utente, Prioridade> h = new Hospital<Utente, Prioridade>(size,17, cmp);
		hash.getDefaultInstance();
		//long inicio = System.currentTimeMillis();
		IO.importar(h, size+"Utentes",hash);
		//System.out.println(System.currentTimeMillis()-inicio + " a fazer insert");
		
		long inicio = System.currentTimeMillis();
		h.poll();
		System.out.println(System.currentTimeMillis()-inicio + " a fazer poll");
		
		inicio = System.currentTimeMillis();
		h.update(h.pick().getNumeroUtente(),new Prioridade("Verde"));
		System.out.println(System.currentTimeMillis()-inicio + " a fazer update");
		
	}

}
