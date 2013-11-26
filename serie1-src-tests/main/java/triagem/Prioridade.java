package triagem;

public class Prioridade extends Comparator {

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
	
	public int corToInt(){
		if(cor.equalsIgnoreCase("Vermelho"))
			return 0;
		if(cor.equalsIgnoreCase("Laranja"))
			return 1;
		if(cor.equalsIgnoreCase("Amarelo"))
			return 2;
		if(cor.equalsIgnoreCase("Verde"))
			return 3;
		return 4;
	}
	
	public void setCor(String c){
		cor = c;
	}
	
	public long getAdmissao(){
		return admissao;
	}
	
	
}
