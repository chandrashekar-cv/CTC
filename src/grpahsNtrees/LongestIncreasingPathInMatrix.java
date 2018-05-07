package grpahsNtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LongestIncreasingPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestIncreasingPath(int[][] matrix) {
		int maxLength = Integer.MIN_VALUE;
		
		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		Map<Integer,Integer> indegree = new HashMap<>();
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				int key = matrix[i][j];
				List<Integer> adjList = new ArrayList<>();
				
				if(i>0 && key < matrix[i-1][j]) { 
					adjList.add(matrix[i-1][j]);
					Integer in = indegree.get(matrix[i-1][j]);
					if(in==null)
						in = 0;
					indegree.put(matrix[i-1][j], in+1);
				}
				if(i<matrix.length-1 &&  key<matrix[i+1][j]) {
					adjList.add(matrix[i+1][j]);
					Integer in = indegree.get(matrix[i-1][j]);
					if(in==null)
						in = 0;
					indegree.put(matrix[i-1][j], in+1);
				}
				if(j>0 && key <matrix[i][j-1]) {
					adjList.add(matrix[i][j-1]);
					Integer in = indegree.get(matrix[i-1][j]);
					if(in==null)
						in = 0;
					indegree.put(matrix[i-1][j], in+1);
				}
				if(j<matrix[0].length && key < matrix[i][j+1] ) {
					adjList.add(matrix[i][j+1]);
					Integer in = indegree.get(matrix[i-1][j]);
					if(in==null)
						in = 0;
					indegree.put(matrix[i-1][j], in+1);
				}
			}
		}
		
		Set<Integer> startNodes = adjMap.keySet();
		Set<Integer> nodesWithDependency = indegree.keySet();
		startNodes.removeAll(nodesWithDependency);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.addAll(startNodes);
		
		if(queue.isEmpty())
			return 0;
		
		while(!queue.isEmpty()) {
			int start = queue.poll();
			
			Stack<Integer> dfsStack = new Stack<Integer>();
			int length = 0;
			dfsStack.push(start);
			while(!dfsStack.isEmpty()) {
				int parent = dfsStack.pop();
				length++;
				
				List<Integer> adjList = adjMap.get(parent);
				
				if(adjList==null || adjList.size()==0) {
					if(maxLength < length)
						maxLength = length;
					length--;
				}
				else {
					for(Integer  child: adjMap.get(parent)) {
						dfsStack.push(child);
					}
				}
				
			}
			
		}
		
		
		return 0;
    }
	
}
