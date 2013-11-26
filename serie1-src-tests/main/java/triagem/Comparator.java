package triagem;

public class Comparator {

	public long compare(Prioridade prio1,Prioridade prio2)
	{
		if(prio1.corToInt() == prio2.corToInt())
		{
			return prio1.getAdmissao() -  prio2.getAdmissao();
		}
		else if(prio1.corToInt() < prio2.corToInt())
		{
			return 1;
		}
		return -1;
			
	}
}
