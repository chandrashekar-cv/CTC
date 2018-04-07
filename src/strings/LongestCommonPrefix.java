package strings;

import java.util.HashSet;
import java.util.Set;

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
