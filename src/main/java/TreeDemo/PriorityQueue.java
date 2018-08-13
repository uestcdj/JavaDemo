package TreeDemo;

import java.util.Arrays;

public class PriorityQueue<T> {
	private int count;
	private int capacity;
	private int extra;
	private Node<T>[] item;
	
	public PriorityQueue(){
		count = 0;
		capacity = 16;
		extra = 8;
		item = new Node[capacity];
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void init() {
		int cur = count / 2;
		int child = cur * 2;
		while(cur > 0) {
			if(child < count && item[child].compareTo(item[child + 1]) <= 0) {
				child++;
			}
			if(item[cur].compareTo(item[child]) <= 0) {
				Node<T> tmp = item[cur];
				item[cur] = item[child];
				item[child] = tmp;
			}
			cur--;
			child = cur * 2;
		}
	}
	
	public void insert(Node<T> newItem) {
		if(count == capacity - 1) {
			capacity += extra;
			item = Arrays.copyOf(item, capacity);
		}
		count++;
		int childLoc = count;
		int parentLoc = childLoc / 2;
		while(parentLoc != 0) {
			if(newItem.compareTo(item[parentLoc]) <= 0) {
				item[childLoc] = newItem;
				return;
			}else {
				item[childLoc] = item[parentLoc];
				childLoc = parentLoc;
				parentLoc /= 2; 
			}
		}
		item[childLoc] = newItem;
	}
	
	public Node<T> remove() {
		if(count == 0) {
			return null;
		}else {
			int curLoc = 1;
			int childLoc = 2 * curLoc;
			Node<T> result = item[curLoc];
			Node<T> tmp = item[count--];
			while(childLoc <= count) {
				if(childLoc < count) {
					if(item[childLoc].compareTo(item[childLoc+1]) <= 0) {
						childLoc++;
					}
				}
				if(item[childLoc].compareTo(tmp) > 0) {
					item[curLoc] = item[childLoc];
					curLoc = childLoc;
					childLoc = curLoc * 2;
					continue;
				}else {
					item[curLoc] = tmp;
					return result;
				}
			}
			item[curLoc] = tmp;
			return result;
		}
				
	}
	
	private	static class Node<T>{
		int val;
		T t;
		
		public int compareTo(Node<T> another) {
			if(this.val < another.val) {
				return -1;
			}else if(this.val == another.val) {
				return 0;
			}else{
				return 1;
			}
		}
	}
	
}
