package schedulingAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

public class CourseSchedule {

	public static void main(String[] args) {
		CourseSchedule sol = new CourseSchedule();
		int[][] course = new int[][] {{1,0},{2,1}};
		System.out.println(sol.canFinish2(3, course));

	}
	
	//Faster execution. No need of n*n matrix. Use an array of lists. 
	//No keeping track of topoligical_order, just have a count to see of all courses are satisfied.
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		
		List<Integer>[] adj = new ArrayList[numCourses];
		Set<Integer> start = new HashSet<>();
		
		//Build adjacency list 
		for(int i=0;i<numCourses;i++) {
			adj[i] = new ArrayList<Integer>();
			start.add(i);
		}
		
		int[] indegree = new int[numCourses];
		for(int[] v: prerequisites) {
			adj[v[1]].add(v[0]);
			//keep track of in-degree of each course
			indegree[v[0]]++;
			//remove course from start which has at least 1 dependency
			start.remove(v[0]);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		//start will contain all courses with no dependencies. They can be completed.
		queue.addAll(start);
		
		int courseCount =0;
		
		//Will hold topological order (one possible solution)
		List<Integer> topologicalOrder = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			courseCount++;
			//keep order of satisfied courses.
			topologicalOrder.add(node);
			for(int v: adj[node]) {
				indegree[v]--;
				//Add course to queue to finish only if all its dependant courses are done => indegree =0
				if(indegree[v]==0)
					queue.add(v);
			}
		}
		//If any course has dependency which can't be satisfied, it will never be added to queue.
		//So courseCount < numCourses. So you will not be completing all courses => false
		return courseCount==numCourses;
		
	}
	
	

}
