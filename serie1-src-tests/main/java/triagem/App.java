package triagem;

import java.util.Scanner;

public class App {

	static Scanner k;
	static Hospital<Utente, Prioridade> h;
	static HashKeyExtractor<Utente>  hash = new HashKeyExtractor<Utente>();
	static Comparator  cmp = new Comparator();
	public static void main(String[] args) {
		
		h = new Hospital<Utente, Prioridade>(10000,17, cmp);
		hash.getDefaultInstance();
		k = new Scanner(System.in);
		int op;
		while(true){
			showMenu();
			op = k.nextInt();
			switch (op){
			case 1:
				add();
				break;
			case 2:
				pick();
				break;
			case 3:
				poll();
				break;
			case 4:
				update();
				break;
			case 5:
				remove();
				break;
			default:
				return;	
				
			}
		}
		
	}

	private static void add() {
		System.out.println("Introduza utente e prioridade no seguinte formato");
		System.out.println("numero; nome apelido; cor; admissão");
		String l = k.next();
		String li = k.nextLine();
		UtentePrioridade up = IO.getUtentePrioridade(l + li);
		h.add(up.getUtente(), up.getPrioridade(), hash);
	}

	private static void pick() {
		Utente u = h.pick();
		System.out.println(u.getNumeroUtente() + " " + u.getNome());
		
	}

	private static void poll() {
		Utente u = h.poll();
		System.out.println(u.getNumeroUtente() + " " + u.getNome());
		
	}

	private static void update() {
		System.out.println("Introduza o numero do utente");
		int u = k.nextInt();
		System.out.println("Introduza a cor da prioridade");
		k.next();
		String c = k.nextLine();
		h.update(u, new Prioridade(c));
		
	}

	private static void remove() {
		System.out.println("Introduza o numero do utente");
		int u = k.nextInt();
		h.remove(u);
		
	}

	private static void showMenu() {
		System.out.println("Aplicação de Triagem");
		System.out.println("1 - Introduzir um novo utente");
		System.out.println("2 - Utente com maior prioridade");
		System.out.println("3 - Remover utente com maior prioridade");
		System.out.println("4 - Alterar prioridade de um utente");
		System.out.println("5 - Remover um utente");
		System.out.println("6 - Sair");
		
	}

}
