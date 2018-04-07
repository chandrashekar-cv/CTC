package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int minMutation(String start, String end, String[] bank) {
		 
		 if(start.equals(end))
			 return 0;
		 
		 char[] charSet = {'A','C','G','T'};
		 Set<String> bankSet = new HashSet<String>();
		 Queue<String> bfsQueue = new LinkedList<String>();
		 Set<String> visited = new HashSet<String>();
		 
		 bankSet.addAll(Arrays.asList(bank));
		 bfsQueue.offer(start);
		 visited.add(start);
		 
		 int level =0;
		 while(!bfsQueue.isEmpty()) {
			 int size = bfsQueue.size();
			 
			 while(size-- > 0) {
				 
				 String currString = bfsQueue.poll();
				 if(currString.equals(end))
					 return level;
				 
				 char[] currCharArray = currString.toCharArray();
				 for(int i=0;i<currCharArray.length;i++) {
					 char currChar = currCharArray[i];
					 
					 for(char c: charSet) {
						 currCharArray[i] = c;
						 String newMutation = new String(currCharArray);
						 if(!visited.contains(newMutation) && bankSet.contains(newMutation)) {
							 bfsQueue.offer(newMutation);
							 visited.add(newMutation);
						 }
					 }
					 currCharArray[i] = currChar;
				 }
			 }
			 level++;
		 }
	      
		 return -1;
	 }

}
