package strings;

import java.util.HashMap;

/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

public class LongestSubStringWithOutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubStringWithOutRepeatingCharacters sol = new LongestSubStringWithOutRepeatingCharacters();
		
		System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));

	}
	
	public int lengthOfLongestSubstring(String s) {
		
		HashMap<Character,Integer> chars = new HashMap<Character, Integer>();
		int max =0;
		int curMax = 0;
		int start = 0;
		
		for(int i=0;i<s.length();i++) {
			Integer pos = chars.get(s.charAt(i));
			
			//If duplicate element is before start ignore it.
			if(pos!=null && pos>=start) {
				start = pos+1;
			}
			
			chars.put(s.charAt(i), i);
			curMax = i-start+1;
			
			if(max<curMax)
				max = curMax;
		}
		
		return max;
		
        
    }

}
