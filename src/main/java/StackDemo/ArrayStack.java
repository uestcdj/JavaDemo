package StackDemo;

public class ArrayStack {
	private int bottom = 0;
	private int top;
	private int capacity;
	
	private Object[] itemArray;
	
	ArrayStack(int n){
		top = 0;
		capacity = n;
		itemArray = new Object[n];
	}
	
	boolean isEmpity() {
		return top == bottom;
	}
	
	void push(Object o) {
		if(top < capacity) {
			itemArray[top++] = o;
		}else {
			throw new StackOverflowError();
		}
	}
	
	Object pop() {
		if(top != bottom) {
			Object tmp = itemArray[--top];
			itemArray[top] = null;
			return tmp;
		}else {
			throw new StackOverflowError();
		}
	}
	
	Object poll() {
		if(top != bottom) {
			return itemArray[top - 1];
		}else {
			throw new StackOverflowError();
		}
	}
}
