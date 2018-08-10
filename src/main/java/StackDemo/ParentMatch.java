package StackDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParentMatch  {
	
	static Map<Character, Character> map = new HashMap<Character, Character>();
	static {
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}
	
	private static String checkPattern(String input) {
		char[] cs = input.toCharArray();
		Stack<Character> s = new Stack<Character>();
		String result = "";
		char tmp;
		for(char c : cs) {
			if(c == '('|| c == '{' || c == '[') {
				s.push(c);
				continue;
			}
			if(c == ')' || c == '}' || c == ']') {
				tmp = map.get(c);
				if(s.isEmpty()) {
					result += tmp + " ";
					continue;
				}
				if(tmp != s.peek()) {
					result += tmp + " ";
				}else {
					s.pop();
				}
			}
		}
		while(!s.isEmpty()) {
			result += map.get(s.pop()) + " ";
		}
		return result;
	}
	
	public static void main(String[] args) {
//		System.out.println(checkPattern("())"));
		System.out.printf(checkPattern("((())"));
	}
}
