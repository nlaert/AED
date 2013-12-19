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
		System.out.println(e.becomeInfected(1));
		System.out.println(e.becomeInfected(4));
		System.out.println(e.becomeInfected(11));
		//e.becomeInfected();
		e.becomeInfectedAfterXDays(1);
	}
}
