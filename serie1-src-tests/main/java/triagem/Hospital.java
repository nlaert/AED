package triagem;

import serie2.Node;

public class Hospital<E,P> extends PriorityQueue<E, P> {
	
	private Node <UtentePrioridade> [] array = new Node [5];
	
	@Override
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator) {
		super.add(elem, prio, keyExtrator);
		UtentePrioridade aux = new UtentePrioridade((Utente)elem, (Prioridade)prio);
		int cor = corToInt(aux.getPrioridade().getCor());
		insert(array[cor], aux);
	}
	
<<<<<<< HEAD
=======
	private int corToInt(String cor){
		if(cor.equals("Vermelho"))
			return 4;
		if(cor.equals("Laranja"))
			return 3;
		if(cor.equals("Amarelo"))
			return 2;
		if(cor.equals("Verde"))
			return 1;
		return 0;
	}
>>>>>>> b9ae65d672cad3742634c70648885f429928bb08
	
}
