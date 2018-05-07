package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.
Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
*/

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
