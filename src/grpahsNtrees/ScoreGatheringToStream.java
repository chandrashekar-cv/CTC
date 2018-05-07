package grpahsNtrees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ScoreGatheringToStream {

	public static void main(String[] args) {
		ScoreGatheringToStream sol = new ScoreGatheringToStream();
		
		System.out.println(sol.solution(new int[] {4,2,5,5,6,1,4}));

	}
	
	public String solution(int[] values) {
		String result = null;
		if (values==null || values.length==0)
			return result;
		
		Node root = new Node(values[0]);
		
		for(int i=1;i<values.length;i++) {
			insert(root,values[i]);
			
			
		}
		result = BFS(root);

		return result;
	}
	
	public void insert(Node node, int val) {
		if(node.val == val) {
			node.count++;
			
		}
		else if(val < node.val) {
			if(node.left!=null)
				insert(node.left,val);
			else {
				Node left = new Node(val);
				node.left = left;
			}
		}
		else {
			if(node.right!=null)
				insert(node.right,val);
			else {
				Node right = new Node(val);
				node.right=right;
			}
			
		}
		
	}
	
	public String BFS(Node root) {
		List<String> result = new ArrayList<>();
		
		Queue<Node> queue= new LinkedList<Node>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			int emptyNodes = 0;
			
			int i=0;
			ArrayList<String> list = new ArrayList<String>(); 
			for(i=0;i<size;i++) {
				
				
				Node current = queue.poll();
				if(current.isEmpty) {
					list.add("");
					emptyNodes++;
				}
				else {
					StringBuilder builder = new StringBuilder();
					builder.append(current.val);
					builder.append(":");
					builder.append(current.count);
					list.add(builder.toString());
					
					Node left = current.left==null? new Node(true): current.left;
					Node right = current.right==null? new Node(true): current.right;
					queue.offer(left);
					queue.offer(right);
				}
				
			}
			if(emptyNodes<size-1)
				result.add(String.join(",", list));
			
		}
		
		return String.join(",", result);
	}

}

class Node{
	int val;
	int count;
	boolean isEmpty = false;
	
	
	Node left = null;
	Node right = null;
	
	public Node(int val) {
		this.val=val;
		
		count=1;
	}
	public Node(boolean empty) {
		isEmpty = empty;
	}
	
}
