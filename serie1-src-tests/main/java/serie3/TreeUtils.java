package serie3;

public class TreeUtils {
	
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
