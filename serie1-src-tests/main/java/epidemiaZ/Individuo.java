package epidemiaZ;

public class Individuo {
	private int identificador;
	private String localidade;
	private char estado;

	
	public Individuo(int identificador, String localidade, char estado)
	{
		this.identificador = identificador;
		this.localidade = localidade;
		this.estado = estado;
	}
	
	public int getIdentificador()
	{
		return identificador;
	}
	
	public String getLocalidade()
	{
		return localidade;
	}
	
	public char getEstado()
	{
		return estado;
	}
}
