<<<<<<< HEAD
package serie3;


public class TreeUtilsTest {
	
	
	public static Node<Integer> zeroToNineBST()
	{
		Node <Integer> root = new Node<Integer>(4);
		root.left = new Node<Integer>(2);
		root.left.right = new Node<Integer>(3);
		root.left.left = new Node<Integer>(1);
		root.left.left.left = new Node<Integer>(0);
		
		root.right = new Node<Integer>(7);
		root.right.left = new Node<Integer>(5);
		root.right.left.right = new Node<Integer>(6);
		root.right.right = new Node<Integer>(8);
		root.right.right.right = new Node<Integer>(9);
		return root;
=======
package serie3;	

public class TreeUtilsTest {
	
	
	public static Node<Integer> createBSTFromRange(){
		return TreeUtils.createBSTFromRange(0, 9);
>>>>>>> 07a074ac146a0fa5899a537c4d473a9630c53322
	}
	
}
