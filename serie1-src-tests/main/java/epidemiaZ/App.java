package epidemiaZ;



import java.io.IOException;

public class App {


	
	
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		EpidemiaZ e = new EpidemiaZ("exemplo.EZ");
		System.out.println(e.becomeInfected(1));
		System.out.println(e.becomeInfected(4));
		System.out.println(e.becomeInfected(11));
	}
}
