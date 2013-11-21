package gestParques;

public class Veiculo {
	
	private String matricula;
	private long registo;
	

	
	public Veiculo (String m, long registo)
	{
		matricula = m;
		this.registo = registo;
	}
	
	public String getMatricula(){
		return matricula;
	}
	
	public long getRegisto(){
		return registo;
	}

	
	
	public String toString(){
		return matricula + ";" + registo;
	}

}
