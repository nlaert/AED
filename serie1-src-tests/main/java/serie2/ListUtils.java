package serie2;

import java.util.Comparator;

public class ListUtils {
	
	public static <E>void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp){
		throw new UnsupportedOperationException();
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
