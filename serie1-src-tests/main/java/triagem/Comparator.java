package triagem;

public class Comparator {

	public long compare(Prioridade prio1,Prioridade prio2)
	{
		if(prio1.corToInt() == prio2.corToInt())
		{
			return prio2.getAdmissao() - prio1.getAdmissao();
		}
		else if(prio1.corToInt() < prio2.corToInt())
		{
			return 1;
		}
		return -1;
			
	}
}
