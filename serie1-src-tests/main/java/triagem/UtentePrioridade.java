package triagem;

public class UtentePrioridade {
	
	private Prioridade prioridade;
	private Utente utente;
	private int key;

	public UtentePrioridade(Utente utente, Prioridade prioridade,int key)
	{
		this.key = key;
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
	
	public int getKey()
	{
		return key;
	}

}
