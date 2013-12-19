package epidemiaZ;

public class HashKeyExtractor<E> implements KeyExtractor<E> { 
	private  KeyExtractor<E> instance = null;

	public KeyExtractor<E> getDefaultInstance(){ 
		if(instance == null) 
			instance = new HashKeyExtractor<E>(); 
		return (KeyExtractor<E>)instance;
		}
	


	@Override
	public int getKey(E e) {
		return e.hashCode();
	}

}