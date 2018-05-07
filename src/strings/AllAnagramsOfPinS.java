package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
public class AllAnagramsOfPinS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllAnagramsOfPinS sol = new AllAnagramsOfPinS();
		
		List<Integer> res = sol.findAnagrams("cbaebabacd","abc");
		System.out.println(res);
		
	}
	
	public HashMap<Integer, Integer> getCount(String p){
		HashMap<Integer,Integer> countMap = new HashMap<>();
		
		for(int i=0;i<p.length();i++) {
			int index = p.charAt(i);
			Integer count =countMap.get(index);
			if(count == null)
				count =0;
			countMap.put(index, count+1);
		}
		
		return countMap;
	}
	
	public List<Integer> findAnagrams(String s, String p){
		
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer,Integer> count = getCount(p);
		
		//Indicates the number of unique characters in P and all the instance of each unique character is present in the sliding window
		int matchCount = 0;
		
		for(int i=0;i<s.length();i++) {
			
			int index = s.charAt(i);
			Integer value = count.get(index);
			if(value!=null) {
				if(value == 1)
					//If all but one instance of a particular character is present in the sliding window and this is the last 
					//instance of that character that should have matched, then increment the matchCount to indicate all instance of a Unique char in P
					//is present in the sliding window
					matchCount++;
				count.put(index, value-1);
			}
			
			if(i>=p.length()) {
				int leftCharInWindow = s.charAt(i-p.length());
				value = count.get(leftCharInWindow);
				if(value!=null) {
					if(value==0)
						//If all the instance of a charater in P were present in the sliding window and 
						//one particular instance is moving out of the window because of the shift, 
						//then decrement matchCount to show that all instances of the unique character is not present in the sliding window.
						matchCount--;
					count.put(leftCharInWindow, value+1);
				}
				
			}
			
			if(matchCount==count.size()) {
				//If all instances of all unique characters are present in the sliding window,
				//Add index of left most character in the sliding window.
				
				result.add(i-p.length()+1);
			}
			
		}
		
		
		return result;
		
	}
	

}
