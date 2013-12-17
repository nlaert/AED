package serie3;

import java.util.EmptyStackException;

public class Queue<E> {
	public Node <E> dummy;
	
	/*left = prev
	 * right = next
	 */
	
	public Queue(){
		dummy = new Node<E>();
		dummy.left = dummy.right = dummy;
	}
	
	public void enqueue(E elem){
		Node <E> aux = new Node<E>(elem);
		aux.right = dummy.right;
		aux.left = dummy;
		
		dummy.right.left = aux;
		dummy.right = aux;		
	}
	
	public E dequeue(){
		if(isEmpty())
			throw new EmptyStackException();
		Node <E> aux = dummy.left;
		aux.left.right = dummy;
		dummy.left = aux.left;
		return aux.value;
	}
	
	private boolean isEmpty() {
		return dummy.right == dummy;
	}

	public static void main(String[] args) {
		int a = 0, b =1, c=2;
		Queue <Integer>q = new Queue<Integer>();
		q.dequeue();
		q.enqueue(a);
		q.enqueue(b);
		System.out.println(q.dequeue());
		q.enqueue(c);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	

}
