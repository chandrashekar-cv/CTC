package strings;

import java.util.HashSet;
import java.util.Set;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.*/

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix sol = new LongestCommonPrefix();
		sol.longestCommonPrefix(new String[]{"",""});

	}
	
	public String longestCommonPrefix(String[] strs) {
		
		if(strs==null || strs.length==0)
			return "";
		if(strs.length==1)
			return strs[0];
		
		StringBuilder prefix = new StringBuilder();
		
		int charIndex = 0;
		boolean endPrefix = false;
		while(true) {
			Set<Character> commonChars = new HashSet<Character>();
			for(int i=0;i<strs.length;i++) {
				if(charIndex >=strs[i].length()) { 
					endPrefix = true;
					break;
				}
				
				commonChars.add(strs[i].charAt(charIndex));
				if(commonChars.size()>1) { 
					endPrefix=true;
					break;
				}
					
			}
			
			if(endPrefix)
				break;
			prefix.append(strs[0].charAt(charIndex));
			charIndex++;
			
		}
		
		return prefix.toString();
        
    }

}
