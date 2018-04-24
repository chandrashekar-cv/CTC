package grpahsNtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.management.Query;

public class CloneAGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()) {
        	UndirectedGraphNode top = queue.poll();
        	
        	for(UndirectedGraphNode neighbor: top.neighbors) {
        		
        		if(!visited.containsKey(neighbor.label)) {
        			visited.put(neighbor.label,new UndirectedGraphNode(neighbor.label));
        			queue.add(neighbor);
        		}
        		
        		visited.get(top.label).neighbors.add(visited.get(neighbor.label));
        	}
        }
        return newNode;
        
    }

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
