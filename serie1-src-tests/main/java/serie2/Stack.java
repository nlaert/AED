package serie2;

import java.util.EmptyStackException;

public class Stack<E> {
	private Node <E> head;
	private Node <E> tail;
	
	public Stack(){
		head = new Node <E>();
		head.next = head;
		tail = new Node <E>();
	}
	
	public void push(E e){
		Node <E> aux = new Node<E> (e);
		if(isEmpty()){
			head.next = aux;
			tail.next = aux;
			aux.previous=head;
		}
		else{
			aux.previous = tail.next;
			tail.next.next = aux;
			tail.next = aux;
		}
	}
	
	public E pop() throws EmptyStackException{
		if (!isEmpty()){
			E aux = tail.next.value;
			tail.next = tail.next.previous;
			if(tail.next == head)
				head.next = head;
			return aux;
		}
		else
			throw new EmptyStackException();
	}
	
	public boolean isEmpty(){
		if (head.next == head)
			return true;
		return false;
	}	
}
