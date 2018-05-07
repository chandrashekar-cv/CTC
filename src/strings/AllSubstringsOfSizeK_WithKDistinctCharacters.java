package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllSubstringsOfSizeK_WithKDistinctCharacters {

	public static void main(String[] args) {
		AllSubstringsOfSizeK_WithKDistinctCharacters sol = new AllSubstringsOfSizeK_WithKDistinctCharacters();
		
		List<String> res = sol.subStringKDist("awaglknagawunagwkwagl", 4);
		
		for(String s: res)
			System.out.println(s);

	}
	
	public List<String> subStringKDist(String input, int k){
		
		Set<String> result = new LinkedHashSet<String>();
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<k;i++) {
			map.put(input.charAt(i), i);
		}
		
		int start = 0;
		
		for(int i=k;i<input.length();i++) {
			
			if(map.size()==k) {
				result.add(input.substring(start, i));
			}
			
			//if to position of the character to be remove is less than or equal to start we remove it as the sliding window moves forward.
			//If its a repeat character, then position is greater than start. So we keep it as its still part of sliding window.
			Integer pos = map.get(input.charAt(start));
			if(pos!=null && pos<=start) { 
				map.remove(input.charAt(start));	
			}
			start++;
			map.put(input.charAt(i), i);
				
		}
		
		
		
		return new ArrayList<String>(result);
		
	}

}
