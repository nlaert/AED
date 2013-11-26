package triagem;

public class Utente<E> implements KeyExtractor<E> {

	private int numero;
	private String nome;
	
	

	public Utente(int numero, String nome){
		this.numero = numero;
		this.nome = nome;
		
		
		
	}
	
	public int getNumeroUtente()
	{
		return numero;
	}
	
	public String getNome(){
		return nome;
	}
	
	
	public int hashCode()
	{
		return numero;
	}

	@Override
	public int getKey(E e) {
		return e.hashCode();
	}
}
