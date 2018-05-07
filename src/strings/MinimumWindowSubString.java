package strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.*/

public class MinimumWindowSubString {

	public static void main(String[] args) {
		MinimumWindowSubString sol = new MinimumWindowSubString();
		
		System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
		

	}
	
	public HashMap<Character, Integer> getCount(String p){
		HashMap<Character, Integer> countP = new HashMap<>();
		
		for(int i=0;i<p.length();i++) {
			char charAtI = p.charAt(i);
			Integer value = countP.get(charAtI);
			if(value==null)
				value = 0;
			countP.put(charAtI, value+1);
			
		}
		
		return countP;
	}
	
	public String minWindow(String s, String p) {
     
		
		HashMap<Character, Integer> countP= getCount(p);
		
		Queue<Integer> startShiftIndex = new LinkedList<Integer>();
		
		int minWindowSize = Integer.MAX_VALUE;
		int minWindowStart =-1;
		int end=0;
		int matchCount = 0;
		
		while(end<s.length()) {
			
			char endChar = s.charAt(end);
			
			Integer countOfEndChar = countP.get(endChar);
			
			if(countOfEndChar!=null) {
				startShiftIndex.add(end);
				if(countOfEndChar==1)
					matchCount++;
				countP.put(endChar, countOfEndChar-1);
			}
			
			
			while(matchCount==countP.size()) {
			
				int start = startShiftIndex.poll();
				int size = end-start+1;
				
				if(size < minWindowSize) {
					minWindowSize = size;
					minWindowStart = start;
				}
				
				char startChar = s.charAt(start);
				Integer startCharCount = countP.get(startChar);
				
				if(startCharCount==0)
					matchCount--;
				countP.put(startChar, startCharCount+1);
				
			}
			end++;
			
		}
		
		String minWindowSubString = minWindowStart < 0 ?"":s.substring(minWindowStart, minWindowStart+minWindowSize);
		
		return minWindowSubString;
    }

}
