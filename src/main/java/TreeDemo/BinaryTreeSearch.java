package TreeDemo;

import java.applet.Applet;

import jdk.dynalink.RelinkableCallSite;

public class BinaryTreeSearch extends Applet {

	public void init() {
		BinarySearchTree T = new BinarySearchTree();
		T.insert("ORY");
		T.insert("JFK");
		T.insert("BRU");
		T.insert("DUS");
		T.insert("ZRH");
		T.insert("MEX");
		T.insert("ORD");
		T.insert("NRT");
		T.insert("ARN");
		T.insert("GLA");
		T.insert("GCM");
		System.out.println("The tree of Fig. 8.29 has been constructed and is:");
		T.print();
		System.out.println();
	}
	
	static class BinarySearchTree{
		private TreeNode root;
		
		private TreeNode insertKey(TreeNode T, ComparisonKey K) {
			if(T == null) {
				TreeNode N = new TreeNode();
				N.key = K;
				return N;
			}else {
				if(K.compareTo(T.key) < 0) {
					T.llink = insertKey(T.llink, K);
				}else {
					T.rlink = insertKey(T.rlink, K);
				}
				return T;
			}
		}
		
		public void print() {
			printNode(root);
			System.out.println();
		}

		private void printNode(TreeNode root) {
			if(root != null) {
				System.out.print("(");
				printNode(root.llink);
				System.out.print(" "+ root.key + " ");
				printNode(root.rlink);
				System.out.print(")");
			}
		}

		void insert(ComparisonKey K) {
			root = insertKey(root, K);
		}
		
		void insert(String K) {
			root = insertKey(root, new StringKey(K));
		}
	}
	
	static class TreeNode{
		ComparisonKey key;
		TreeNode llink;
		TreeNode rlink;
	}
	
	interface ComparisonKey{
		
		int compareTo(ComparisonKey value);
		
		String toString();
	}
	
	static class StringKey implements ComparisonKey{

		private String key;
		
		StringKey(String key){
			this.key = key;
		}
		
		@Override
		public int compareTo(ComparisonKey value) {
			String a = this.key;
			String b = value.toString();
			return a.compareTo(b);
		}
		
		public String toString() {
			return key;
		}
		
	}
	
}
