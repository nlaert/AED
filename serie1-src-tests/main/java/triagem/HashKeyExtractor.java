package triagem;

public class HashKeyExtractor implements KeyExtractor<Object> { 
	private static KeyExtractor<Object> instance = null;

	public static KeyExtractor<Object> getDefaultInstance(){ 
		if(instance == null) instance = new HashKeyExtractor(); 
			return (KeyExtractor<Object>)instance;}
	


	@Override
	public int getKey(Object e) {
		return e.hashCode();
	}

}