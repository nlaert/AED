package epidemiaZ;



import java.io.IOException;

public class App {


	
	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		EpidemiaZ e = new EpidemiaZ("exemplo.EZ");
		//e.epidemia();
//		UniaoPorRank uniao = new UniaoPorRank(13);
//		uniao.uniao(2, 1,1);
//		uniao.uniao(3, 1,1);
//		uniao.uniao(4, 3,2);
//		uniao.uniao(8, 7,1);
//		uniao.uniao(6, 7,1);
//		System.out.println(e.becomeInfected(1));
//		System.out.println(e.becomeInfected(4));
//		System.out.println(e.becomeInfected(11));
//		e.becomeInfected();
//		e.becomeInfectedAfterXDays(1);
//		CidadeInfectada c1 = new CidadeInfectada("Lisboa");
//		CidadeInfectada c2 = new CidadeInfectada("Porto");
//		CidadeInfectada c3 = new CidadeInfectada("Faro");
//		CidadeInfectada c4 = new CidadeInfectada("Coimbra");
//		if(e.hash.search(c1) == null)
//		{
//			e.hash.insert(c1);
//		}
		//e.hash.delete(c1);
//		e.hash.search(c1).setDias(4);
		e.riskAreas(2);
		

	}
}
