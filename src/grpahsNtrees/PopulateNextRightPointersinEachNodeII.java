package grpahsNtrees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersinEachNodeII {

	public static void main(String[] args) {
		PopulateNextRightPointersinEachNodeII sol = new PopulateNextRightPointersinEachNodeII();
		
		TreeLinkNode root = new TreeLinkNode(1);
		sol.connect(root);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		n2.left = n4;
		n2.right = n5;
		TreeLinkNode n7 = new TreeLinkNode(7);
		n3.right = n7;
		root.left = n2;
		root.right = n3;
		sol.connect(root);

	}
	public void connect(TreeLinkNode root) {
		
		if(root==null)
			return;
		
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			for(int i=0;i<qSize;i++) {
				TreeLinkNode node = queue.poll();
				TreeLinkNode next = i==qSize-1? null: queue.peek();
				node.next = next;
				
				if(node.left!= null)
					queue.offer(node.left);
				if(node.right!=null)
					queue.offer(node.right);
			}
		}
		
		
    }

}

class TreeLinkNode{
	int val;
	TreeLinkNode left,right,next;
	public TreeLinkNode(int x) {
		this.val=x;
	}
}
