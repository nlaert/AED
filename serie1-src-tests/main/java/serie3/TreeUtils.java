package serie3;

import java.util.Comparator;

public class TreeUtils {
	
	
	public static <E> boolean contains (Node <E> root, E min, E max, Comparator <E> cmp)
	{
		if(root == null)
			return false;
		if(cmp.compare(root.value, min) >= 0 && cmp.compare(root.value, max) <=0)
			return true;
		if(cmp.compare(root.value, max)> 0)
			return contains(root.left,min,max,cmp);
		return contains(root.right,min,max,cmp);
		
	
	}
	
	public static Node <Integer> createBSTFromRange(int start, int end){
		if(start>=end)
			return null;
		//int mid = (start+end)/2;
		Node <Integer> root = new Node<Integer>();
		createBSTAux(root, start, end);
		return root;
	}

	private static void createBSTAux(Node<Integer> root, int start, int end) {
		if(start>end)
			return;
		int mid = (start+end)/2;
		Node <Integer> aux = new Node<Integer>(mid);
		createBSTAux(root.left, start, mid-1);
		createBSTAux(root.right, mid+1, end);
		
	}

}