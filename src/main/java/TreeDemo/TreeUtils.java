package TreeDemo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeUtils {
	
	private static final int PRE_ORDER = 1;

	private static final int IN_ORDER = 1;
	
	private static final int POST_ORDER = 1;
	
	static void traverse(TreeNode root, int traversalOrder) {
		if(root != null) {
			if(traversalOrder == PRE_ORDER) {
				visit(root);
				traverse(root.llink, traversalOrder);
				traverse(root.rlink, traversalOrder);
			}else if(traversalOrder == IN_ORDER) {
				traverse(root.llink, traversalOrder);
				visit(root);
				traverse(root.llink, traversalOrder);
			}else if(traversalOrder == POST_ORDER) {
				traverse(root.llink,traversalOrder);
				traverse(root.llink,traversalOrder);
				visit(root);
			}
		}
	}
	
	static void preOrderTraversal1(TreeNode root) {
		Stack<TreeNode> S = new Stack<TreeNode>();
		TreeNode N;
		S.push(root);
		while(!S.isEmpty()) {
			N = S.pop();
			if(N != null) {
				System.out.println(N.info);
				S.push(N.rlink);
				S.push(N.llink);
			}
		}
	}
	
	static void preOrderTraversal2(TreeNode root) {
		Stack<TreeNode> S = new Stack<TreeNode>();
		TreeNode tmp = root;
		while(tmp != null || !S.isEmpty()) {
			while(tmp != null) {
				visit(tmp);
				S.push(tmp);
				tmp = tmp.llink;
			}
			if(!S.isEmpty()) {
				tmp = S.pop();
				tmp = tmp.rlink;
			}
		}
	}
	
	static void inOrderTraversal(TreeNode root) {
		Stack<TreeNode> S = new Stack<TreeNode>();
		TreeNode tmp = root;
		while(tmp != null || !S.isEmpty()) {
			while(tmp != null) {
				S.push(tmp);
				tmp = tmp.llink;
			}
			if(!S.isEmpty()) {
				tmp = S.pop();
				visit(tmp);
				tmp = tmp.rlink;
			}
		}
	}
	
	static void postOrderTraversal(TreeNode root) {
		Stack<TreeNode> S1 = new Stack<TreeNode>();
		Stack<Integer> S2 = new Stack<Integer>();
		TreeNode tmp = root;
		int a = 1;
		while(tmp != null || !S1.isEmpty()) {
			while(tmp != null) {
				S1.push(tmp);
				S2.push(0);
				tmp = tmp.llink;
			}
			while(!S1.isEmpty() && S2.peek() == a) {
				S2.pop();
				visit(S1.pop());
			}
			if(!S1.isEmpty()) {
				S2.pop();
				S2.push(1);
				tmp = S1.peek();
				tmp = tmp.rlink;
			}
		}
	}
	
	static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> Q = new ArrayDeque<TreeNode>();
		Q.add(root);
		TreeNode tmp;
		while(!Q.isEmpty()) {
			tmp = Q.remove();
			visit(tmp);
			if(tmp.llink != null) {
				Q.add(tmp.llink);
			}
			if(tmp.rlink != null) {
				Q.add(tmp.rlink);
			}
		}
	}
	
	static void visit(TreeNode node) {
		System.out.println(node.info);
	}

}
