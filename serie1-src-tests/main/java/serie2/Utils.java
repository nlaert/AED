package serie2;

public class Utils {

	public static boolean verifyXML(String str){
		
		int id1 = 0, id2 = 0, strLength = str.length();
		String aux;
		Stack<String> st = new Stack<String>();
		while (id2<=strLength){
			if(str.length()==0)
				return st.isEmpty();
			id1 = str.indexOf('<');
			id2 = str.indexOf('>');
			if(id1 <0 || id2 <0 || id1>id2)
				return false;
			aux = str.substring(id1+1, id2);
			if (aux.charAt(0)!='/')
				st.push(aux);
			else if(!st.isEmpty()){
				String s = st.pop();
				if(!aux.substring(1).equals(s))
					return false;
			}
			else 
				return false;
			str = str.substring(id2+1);
		}
		return st.isEmpty();
	}
	


    public static <E> Iterable<Pair<E, Integer>> histogram (final E[] array){
		throw new UnsupportedOperationException();
		}
	



}


