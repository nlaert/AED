package triagem;

public class Hospital<E,P> extends PriorityQueue<E, P> {
	
	private UtentePrioridade [] array = new UtentePrioridade[5];
	
	@Override
	public void add(E elem, P prio, KeyExtractor<E> keyExtrator) {
		// TODO Auto-generated method stub
		super.add(elem, prio, keyExtrator);
		UtentePrioridade aux = new UtentePrioridade((Utente)elem, (Prioridade)prio);
		String cor = aux.getPrioridade().getCor();
		
	}
	
	private int corToInt()
	
}
