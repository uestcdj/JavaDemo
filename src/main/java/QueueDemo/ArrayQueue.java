package QueueDemo;

public class ArrayQueue<T> {
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	private int capacity;
	private int extra;
	private Object[] item;
	
	ArrayQueue(){
		capacity = 10;
		extra = capacity / 2;
		item = new Object[capacity];
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	void add(T t) {
		if(size == capacity) {
			Object[] tmp = new Object[capacity += extra];
			for(int i = 0; i < size; i++) {
				tmp[i] = item[(i + head) % size];
			}
			item = tmp;
			head = 0;
			tail = size - 1;
		}
		item[tail] = t;
		tail = (++tail) % capacity;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	T remove() {
		if(size == 0) {
			throw new StackOverflowError();
		}
		Object tmp =  item[head];
		item[head++] = null;
		head = head % capacity;
		size--;
		return (T)tmp;
		
	}
}
