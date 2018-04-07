package strings;

import java.util.HashMap;

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
