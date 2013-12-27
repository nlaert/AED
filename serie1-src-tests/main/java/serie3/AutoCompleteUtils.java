package serie3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoCompleteUtils {

	public static TNode loadWordsFromFile(TNode root, String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		char c;
		TNode aux;
		while((line=br.readLine())!=null){
			line.toLowerCase();
			aux = root;
			for(int i=0;i<line.length();i++){
				c=line.charAt(i);
				if(c>='a' && c<='z'){
					if(aux.array[c-'a']==null)
						aux.array[c-'a'] = new TNode();
					aux = aux.array[c-'a'];
					if(i==line.length()-1)
						aux.wordEnd = true;
				}
				else{
					if(aux!=root){
						aux.wordEnd = true;
						aux = root;
					}
				}
			}
		}
		br.close();
		return root;
	}
	
	public static <E> LNode <E> suggestPossibleWords(TNode root, String prefix)
	{
		LNode <String> lnode = new LNode<String>();
		lnode.next = lnode.previous = lnode;
		int letra; 
		TNode nodeAux=root;
		for(int j = 0; j<prefix.length();j++)
		{
			int bla = prefix.charAt(j)-'a';
			nodeAux = nodeAux.array[bla];
			if(nodeAux == null)
				return null;
		}
		int i = 0;
		while(i<nodeAux.array.length)
		{
			if(nodeAux.array[i] != null)
			{
				lnode = pesquisa(lnode,nodeAux.array[i],prefix);
			}
			i++;
		}
		

		
		return (LNode<E>) lnode;

	}
		
	public static <E> LNode <E> pesquisa(LNode <String> lnode,TNode nodeAux, String prefix)
	{
		String auxString = prefix;

		if(nodeAux.array == null)
		{
			return (LNode<E>) lnode;
		}

		int i = 0;
		while(i<nodeAux.array.length)
		{
			if(nodeAux.array[i] != null)
			{
				if(!nodeAux.array[i].wordEnd)
				{
					auxString += Character.toString((char)('a'+i));
					nodeAux = nodeAux.array[i];


				}

				else 
				{
					auxString += Character.toString((char)('a'+i));
					insert(lnode,auxString);
					nodeAux = nodeAux.array[i];

				}
			}
			i++;
		}
		return (LNode<E>) lnode;
	}


	
	public static <E> void insert(LNode<String> lnode,String value)
	{
		LNode<String> aux1 = new LNode<String>();
		aux1.next = lnode.next;
		aux1.next.previous = aux1;
		lnode.next = aux1;
		aux1.previous = lnode;
		aux1.value = value;
		
	}
	
	public static <E>void print(LNode<E> lnode)
	{
		LNode <String> aux = (LNode<String>) lnode.next;
		while(aux != lnode)
		{
			System.out.println(aux.value);
			aux=aux.next;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		
		TNode root = new TNode();
		
		root =  loadWordsFromFile(root, "teste.txt");
		System.out.println();
		print(suggestPossibleWords(root, "est"));
		
		
		
		
	}
	
//	String auxString = prefix;
//	TNode search = nodeAux;
//	int i = 0;
//	while(i< search.array.length)
//	{
//		if(nodeAux.array[i] != null)
//		{
//			if(!nodeAux.array[i].wordEnd)
//			{
//				auxString += Character.toString((char)('a'+i));
//				nodeAux = nodeAux.array[i];
//
//			}
//
//			else 
//			{
//				auxString += Character.toString((char)('a'+i));
//				insert(lnode,auxString);
//				//					i = 0;
//				nodeAux = nodeAux.array[i];
//
//				//auxString = prefix;
//			}
//
//			i = 0;
//
//		}
//		i++;
//
//	}
//
//	return (LNode<E>) lnode;
	
	
	
}
