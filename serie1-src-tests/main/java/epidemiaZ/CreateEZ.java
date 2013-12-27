package epidemiaZ;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.*;

import sun.util.resources.CalendarData;

public class CreateEZ {
	

	public static void create(String nomeFicheiro, int tamanho, EpidemiaZ epidemia) throws IOException
	{
		Calendar c = Calendar.getInstance();
//		System.out.println(c.get(c.YEAR)+"-"+(c.get(c.MONTH)+1)+"-"+c.get(c.DAY_OF_MONTH));
		PrintWriter writer = new PrintWriter(nomeFicheiro);
		PrintWriter writerEdges = new PrintWriter("edges.EZ");
		PrintWriter writeIndividuos = new PrintWriter("individuos.EZ");
		Edge [] edge = new Edge[tamanho+1];
		Edge auxEdge;
		int aux;
		for(int i = 1; i< edge.length;i++)
		{
			aux = (int)(Math.random()*tamanho+1);
			while(aux == i){
				aux = (int)(Math.random()*tamanho+1);
			}
				
			if(edge[i] == null)
				edge[i] = new Edge(i);
			epidemia.insert(edge[i], aux);
			if(edge[aux] == null)
				edge[aux] = new Edge(aux);
			epidemia.insert(edge[aux], i);
		}
		
		writer.println(tamanho);
		writer.println(c.get(c.YEAR)+"-"+(c.get(c.MONTH)+1)+"-"+c.get(c.DAY_OF_MONTH));
		
		for(int i = 1; i<= tamanho;i++ )
		{
			
			writer.print(i+"\t"+localidade()+"\t"+estado()+"\t");
			auxEdge = edge[i];
			while(auxEdge.next!= null)
			{
				writer.print(auxEdge.next.id+"\t");
				auxEdge=auxEdge.next;
			}
			writer.println();

		}
		writeIndividuos.println("ID\tLocalidade\tEstado");
		
		for(int i = 1; i<= tamanho;i++ )
		{
			writeIndividuos.println(i+"\t"+localidade()+"\t"+estado()+"\t");
		}
		
		for(int i = 1; i<=tamanho;i++)
		{
			auxEdge = edge[i];
			while(auxEdge.next!= null)
			{
				writerEdges.println(auxEdge.id+"\t"+auxEdge.next.id);
				auxEdge=auxEdge.next;
			}
		}
		writerEdges.close();
		writeIndividuos.close();
		writer.close();
	}
	
	
	
	public static String localidade()
	{
		int i = (int)(Math.random() * 6);
		switch(i)
		{
		case 0:
			return "Faro";
		case 1:
			return "Peniche";
		case 2:
			return "Lisboa";
		case 3:
			return "Porto";
		case 4:
			return "Ericeira";
		case 5:
			return "Coimbra";
		default:
			return null;
		}
		
	}
	
	public static char estado()
	{
		int i = (int)(Math.random() * 3);
		switch(i)
		{
		case 0:
			return 'R';
		case 1:
			return 'I';
		case 2:
			return 'S';
		default: 
			return ' ';
		
		}
		
	}
	
	
}
