package epidemiaZ;

public class Connection {
	
	private int representante;
	private int dias;
	
	public Connection(int representante)
	{
		this.representante = representante;
		this.dias = -1;
	}
	
	public int getRepresentante()
	{
		return representante;
	}
	public int getDias()
	{
		return dias;
	}
	public void setRepresentante(int representante)
	{
		this.representante = representante;
	}
	public void setDias(int dias)
	{
		this.dias = dias;
	}

}
