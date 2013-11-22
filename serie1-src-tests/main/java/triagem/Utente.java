package triagem;

public class Utente {

	private int numero;
	private String nome;
	private int indice;

	public Utente(int numero, String nome, int indice){
		this.numero = numero;
		this.nome = nome;
		this.indice = indice;
	}
	
	public int getNumeroUtente()
	{
		return numero;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getIndice(){
		return indice;
	}
	
	public int hashCode()
	{
		return numero;
	}
}
