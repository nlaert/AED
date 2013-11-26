package serie2;

import java.util.Comparator;

public class ListUtils {
	
	public static <E>void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp){
		if(first == null ||  last == null )
		{
			return;
		}
		Node <E> i;
		if (first == last || first.previous == last  || last.previous.next == first )
			return;
		i = partition(first, last, cmp);
		quicksort(first, i.previous,cmp);
		quicksort(i.next, last,cmp);
		
			
		
	}
	
	
	public static <E> Node<E> partition(Node <E> l, Node <E> r, Comparator <E> cmp){
	    Node <E> x=r; //pivot
	    Node <E> i=l;
	    Node <E> j = l;
	    while(j != r && j.next != null )
	    {
	      if(cmp.compare(j.value, x.value) <= 0){
	    	  exchange(i,j);
	    	  i=i.next;
	       }
	      j = j.next;
	    }
	    
	      exchange(i,r);
	      return i;
	}
	
	public static <E> void exchange(Node<E> node1, Node <E> node2){
		  E tmp = node1.value;
		  node1.value = node2.value;
		  node2.value = tmp;		
		}
	
	
	
	public static Node<Node<String>> splitBySentence(Node<String> list){
		Node<Node<String>> res = new Node<Node<String>>();
		res.next = res.previous = res;
		if(list.next==list){
			return res;
		}
		
		Node<String> listDummy, head, tail;
		listDummy = list;
		head = tail = list.next;
		
		while(listDummy.next != list && tail.next != list){
			if(!tail.value.equals(".")){
				tail = tail.next;
			}				
			else{
				if(head == tail){
					listDummy=tail;
					head=tail=tail.next;
				}
				else{
					listDummy.next = tail;
					tail = tail.previous;
					listDummy.next.previous = listDummy;
					insert(res,head,tail);
					listDummy = listDummy.next;
					head = tail = listDummy.next;
				}
			}
		}
		if(!tail.value.equals(".")){
			listDummy.next = list;
			list.previous = listDummy;
			insert(res,head,tail);
		}
		else{
			if(head !=tail){
				listDummy.next = tail;
				tail = tail.previous;
				listDummy.next.previous = listDummy;
				insert(res,head,tail);
			}
		}
		return res;
	}

	private static void insert(Node<Node<String>> dummy, Node<String> head, Node <String> tail) {
		Node <Node<String>> newNode = new Node<Node<String>>();
		
		head.previous = tail.next = null;
		newNode.value = head;
		
		newNode.next = dummy;
		newNode.previous = dummy.previous;
		dummy.previous = newNode;
		newNode.previous.next = newNode;
	}
}
	
	


