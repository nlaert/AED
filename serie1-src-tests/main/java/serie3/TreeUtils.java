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
		if(start>end)
			return null;
		int mid = (start+end)/2;
		Node <Integer> root = new Node<Integer>(mid);
		root.left=createBSTFromRange(start, mid-1);
		root.right=createBSTFromRange(mid+1, end);
		return root;
	}
	
	public  static <E> boolean isAllLeavesInSameLevel(Node <E> root)
	{
		if(level(root) >= 1)
			return true;
		return false;
	}
	
	public static <E> int level(Node<E> root){
		if(root==null){
			return 0;
		}
		int k1=level(root.left);
		int k2=level(root.right);
		return k1==k2?k1+1:-1;
	}

}
