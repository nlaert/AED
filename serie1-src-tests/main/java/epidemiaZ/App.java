package epidemiaZ;



import java.io.IOException;
import java.util.Scanner;

public class App {




	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		EpidemiaZ e = new EpidemiaZ("exemplo.EZ");
//		EpidemiaZ e = new EpidemiaZ("testeEZ.EZ");
		Scanner kbd = new Scanner(System.in);
//		e.createEZ("testeEZ.EZ", 10);
		int op;
		int u;
		while(true){
			showMenu();
			op = kbd.nextInt();
			switch (op){
			case 0:
				System.out.println("Qual o tamanho do ficheiro?");
				u = kbd.nextInt();
				e = new EpidemiaZ(u);
				break;
			case 1:
				System.out.println("Introduza o identificador do individuo");
				u = kbd.nextInt();
				System.out.println(e.becomeInfected(u));
				break;
			case 2:
				e.becomeInfected();
				break;
			case 3:
				System.out.println("Introduza o numero de dias");
				u = kbd.nextInt();
				e.becomeInfectedAfterXDays(u);
				break;
			case 4:
				System.out.println("Introduza o numero de dias");
				u=kbd.nextInt();
				e.riskAreas(u);
				break;
			case 5:
				e.e();
				break;
			default:
				return;	

			}
		}


		}
		private static void showMenu() {
			System.out.println("Aplicacao de Epidemias");
			System.out.println("0 - Gerar novo ficheiro");
			System.out.println("1 - BecomeInfected? i");
			System.out.println("2 - BecomeInfected?");
			System.out.println("3 - BecomeInfectedAfterXDays? x");
			System.out.println("4 - RiskAreas? x");
			System.out.println("5 - Sair");

		}
}
