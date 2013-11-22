package triagem;

public class Prioridade {

	private String cor;
	private long admissao;
	
	public Prioridade(String cor, long admissao){
		this.cor = cor;
		this.admissao = admissao;
	}
	
	public Prioridade(String cor){
		this.cor = cor;
		this.admissao = System.currentTimeMillis();
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
