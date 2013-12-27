package epidemiaZ;

import java.util.EmptyStackException;

public class Queue<E> {
	public Node <E> dummy;
	
	
	public Queue(){
		dummy = new Node<E>();
		dummy.previous = dummy.next = dummy;
	}
	
	public void enqueue(E elem){
		Node <E> aux = new Node<E>(elem);
		aux.next = dummy.next;
		aux.previous = dummy;
		
		dummy.next.previous = aux;
		dummy.next = aux;		
	}
	
	public E dequeue(){
		if(isEmpty())
			throw new EmptyStackException();
		Node <E> aux = dummy.previous;
		aux.previous.next = dummy;
		dummy.previous = aux.previous;
		return aux.value;
	}
	
	public boolean isEmpty() {
		return dummy.next == dummy;
	}


}
