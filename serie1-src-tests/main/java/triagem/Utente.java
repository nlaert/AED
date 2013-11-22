package triagem;

public class Utente {

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
}
