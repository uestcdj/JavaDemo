package StackDemo;

public class ArrayStack2<T> {
	private int count = 0;
	private int capacity;
	private int extra;
	private Object[] item;
	
	ArrayStack2(int n){
		capacity = n;
		extra = (n >> 1);
		item = new Object[n];
	}
	
	boolean isEmpty() {
		return count == 0;
	}
	
	void push(T t) {
		if(count >= capacity) {
			Object[] tmp = new Object[capacity += extra];
			for(int i = 0; i < count; i++) {
				tmp[i] = item[i];
			}
			item = tmp;
		}
		item[count++] = t;
	}
	
	@SuppressWarnings("unchecked")
	T pop() {
		if(count == 0) {
			return null;
		}
		return (T) item[--count];
	}
	
	@SuppressWarnings("unchecked")
	T peek() {
		if(count == 0) {
			return null;
		}
		return (T) item[count - 1];
	}
}
