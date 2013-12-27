package epidemiaZ;

import java.io.IOException;

public class AppTeste {

	public static void main(String[] args) throws IOException {
		int tamanho = 10000;
		long start = System.currentTimeMillis();
		EpidemiaZ ep = new EpidemiaZ("ficheiroCriado"+tamanho+".EZ");
		ep.riskAreas(tamanho);
		System.out.println((System.currentTimeMillis()-start)+"ms");
	}

}
