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
	
	
}
