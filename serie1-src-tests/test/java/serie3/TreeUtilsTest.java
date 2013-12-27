package serie3;

import java.util.Comparator;

public class TreeUtilsTest<E> {
	
	static final Comparator<Integer> cmp= new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	};
	
	public static boolean rootWithNoChild(Node <Integer> root){
		if(root==null)
			return false;
		return (root.left==null && root.right == null);
	}
	
	public static boolean isBST(Node<Integer> root){ //iguais a esquerda
		if (root==null) return true;
		if(root.right!=null && root.left!=null)
			if((cmp.compare(root.value,root.left.value)<0) || (cmp.compare(root.value, root.right.value)>=0))
				return false;
		if(!isBST(root.left) || !isBST(root.right))
			return false;
		return true;
		
	}
}
