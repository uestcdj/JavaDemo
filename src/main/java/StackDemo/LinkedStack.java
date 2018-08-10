package StackDemo;

public class LinkedStack<T> {
	
	private Node<T> head;
	private Node<T> end;
	private int size;
	
	LinkedStack(){
		head = new Node<>();
		end = head;
		size = 0;
	};
	
	boolean isEmpty() {
		return size == 0;
	}
	
	void push(T t) {
		Node<T> tmp = new Node<T>(t, end, null);
		end.nex = tmp;
		end = tmp;
	}
	
	T pop() {
		if(size != 0) {
			Node<T> tmp = end;
			tmp.pre.nex = null;
			end = tmp.pre;
			tmp.pre = null;
			return tmp.val;
		}
		return null;
	}
	
	T peek() {
		return end.val;
	}

	private static class Node<T>{
		
		T val;
		Node<T> pre;
		Node<T> nex;
		
		Node(){
		}
		
		Node(T t, Node<T> pre, Node<T>nex){
			this.val  = t;
			this.pre = pre;
			this.nex = nex;
		}
	}
		
}
