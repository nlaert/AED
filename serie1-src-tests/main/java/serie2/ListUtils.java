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
		Node <Node<String>> res = new Node<Node<String>>();
		res.next = res.previous = res;
		if(list.next==list)
			return res;
		Node <Node<String>> resDummy = res;
		Node <String> dummy;
		list = list.next;
		while(list.value!=null){
			resDummy.value = new Node <String>();
			dummy = resDummy.value;
			dummy.next = dummy.previous = dummy;
			while(list.value!=null && !list.value.equals(".")){
				copy(list, dummy);
				list = list.next;
			}
			
			insert(resDummy, new Node<Node<String>>());
			resDummy = resDummy.next;
		}
		return res;
	}


	private static <E> void insert(Node<E> dummy, Node<E> newNode) {
		newNode.next = dummy.next;
		newNode.previous = dummy;
		dummy.next.previous = newNode;
		dummy.next = newNode;
	}


	private static <E> void copy(Node<E> src, Node<E> dst) {
		src.previous.next = src.next;
		src.next.previous = src.previous;
		
		insert(dst,src);
		
	}
	
	

}
