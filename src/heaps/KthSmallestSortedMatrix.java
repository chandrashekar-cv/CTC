package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSortedMatrix {

	public static void main(String[] args) {
		KthSmallestSortedMatrix sol = new KthSmallestSortedMatrix();
		System.out.println(sol.findKthSmallestElement(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));

	}
	
	class cell{
		int val,col,row;
		
		public cell(int row,int col,int val) {
			this.row=row;
			this.col=col;
			this.val=val;
		}
	}
	int findKthSmallestElement(int[][] matrix, int k) {
		
		if(matrix==null ||matrix.length==0  || k<1)
			return -1;
		
		PriorityQueue<cell> minHeap =new PriorityQueue<cell>(k, new Comparator<cell>() {
			@Override
			public int compare(cell o1,cell o2) {
				return o1.val-o2.val;
			}
		});
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		minHeap.offer(new cell(0,0,matrix[0][0]));
		int count = 0;
		visited[0][0]=true;
		cell current = minHeap.peek();
		
		do{
			
			current = minHeap.poll();
			count++;
			
			int row= current.row;
			int col= current.col;
			
			if(row+1< rows && !visited[row+1][col]) {
				minHeap.offer(new cell(row+1,col,matrix[row+1][col]));
				visited[row+1][col] = true;
			}
				
			
			if(col+1< columns && !visited[row][col+1]) {
				minHeap.offer(new cell(row,col+1,matrix[row][col+1]));
				visited[row][col+1]=true;
			}
				
		}while(!minHeap.isEmpty() && count<k);
		
		if(count<k)
			return -1;
		
		return current.val;
		
	}

}
