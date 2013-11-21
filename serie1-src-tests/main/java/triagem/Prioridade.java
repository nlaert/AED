package triagem;

public class Prioridade {

	private String cor;
	private long admissao;
	
	public Prioridade(String cor, long admissao){
		this.cor = cor;
		this.admissao = (admissao<=0)? System.currentTimeMillis() : admissao;
	}
	
	public String getCor(){
		return cor;
	}
	
	public void setCor(String c){
		cor = c;
	}
	
	public long getAdmissao(){
		return admissao;
	}
}
