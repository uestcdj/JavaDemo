package QueueDemo;

public class LinkedQueue<T> {
	
	private Node<T> head;
	
	private Node<T> tail;
	
	private int size = 0;
	
	boolean isEmpty() {
		return size == 0;
	}
	
	void push(T t) {
		if(size == 0) {
			head = tail = new Node<T>(t, null, null);
			size++;
		}
		Node<T> tmp = tail.nex = new Node<T>(t, tail, null);
		tail = tmp;
		size++;
	}
	
	T pop() {
		if(size == 0) {
			return null;
		}
		Node<T> tmp = head;
		if(head.nex == null) {
			head = null;
			tail = null;
			size--;
			return tmp.val;
		}
		head.nex.pre = null;
		head = head.nex;
		size--;
		return tmp.val;
	}
	
	T peek() {
		if(size == 0) {
			return null;
		}
		return head.val;
	}
	
	private static class Node<T>{
		T val;
		Node<T> pre;
		Node<T> nex;
		
		Node(){
			
		}
		
		Node(T t, Node<T> pre, Node<T> nex){
			val = t;
			this.pre = pre;
			this.nex = nex;
		}
	}

}
