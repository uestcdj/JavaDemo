package StringDemo;

import java.util.Arrays;

public class StringBufferDemo {
	
	static class StringBuffer{
		private int size;
		private int capacity;
		private char[] buff;
		
		StringBuffer(){
			this.size = 0;
			this.capacity = 10;
			this.buff = new char[10];
		}
		
		StringBuffer append(String s) {
			int len = s.length();
			ensureCapacity(size + len);
			for(int i = 0; i < len; i++) {
				buff[i + size] = s.charAt(i);
			}
			size += len;
			return this;
		}
		
		char CharAt(int index) {
			return buff[index];
		}
		
		void ensureCapacity(int minCapacity) {
			if(minCapacity <= capacity) {
				return;
			}
			char[] tmp = Arrays.copyOf(buff, minCapacity);
			capacity = minCapacity;
			buff = tmp;
		}
		
		int capacity() {
			return this.capacity;
		}
		
	}
	
}
