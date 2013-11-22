package triagem;

public class UtentePrioridade<E,P> {
	
	private Prioridade prioridade;
	private Utente utente;

	public UtentePrioridade(Utente utente, Prioridade prioridade)
	{
		this.utente = utente;
		this.prioridade = prioridade;
	}
	
	public Utente getUtente()
	{
		return utente;
	}
	
	public Prioridade getPrioridade()
	{
		return prioridade;
	}

}
