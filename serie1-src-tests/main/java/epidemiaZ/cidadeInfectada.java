package epidemiaZ;

public class cidadeInfectada {
	private String nome;
	private int dias;
	
	public cidadeInfectada(String nome){
		this.nome = nome;
		dias = -1;
	}

	public String getNome() {
		return nome;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	@Override
	public int hashCode(){
		return nome.hashCode();
	}
	
	public boolean equals(cidadeInfectada ci){
		return nome.equalsIgnoreCase(ci.getNome());
			
	}

}
