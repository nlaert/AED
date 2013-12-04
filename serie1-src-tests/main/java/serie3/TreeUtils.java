package serie3;
import java.util.Comparator;

public class TreeUtils {
	
	
	public static <E> boolean contains (Node <E> root, E min, E max, Comparator <E> cmp)
	{
		if(root == null)
			return false;
		if(cmp.compare(root.key, min) >= 0 && cmp.compare(root.key, max) <=0)
			return true;
		if(cmp.compare(root.key, max)> 0)
			return contains(root.left,min,max,cmp);
		return contains(root.right,min,max,cmp);
		
	
		
		
		
	}

}
