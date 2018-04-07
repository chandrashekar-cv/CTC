package strings;

import java.util.Arrays;

public class HasAllUniqueCharacters {

	public static void main(String[] args) {
		HasAllUniqueCharacters sol = new HasAllUniqueCharacters();
		System.out.println(sol.hasAllUniquecCharacters(" "));
		System.out.println(sol.hasAllUniqueCharacters2(" "));
		
	}
	
	//No extra memory used. Sorting take O(n log.n) space O(1)
	public boolean hasAllUniquecCharacters(String s) {
		
		if(s==null || s.length()<2)
			return true;
		
		char[] charList = s.toCharArray();
		
		Arrays.sort(charList);
		for(int i=0;i<charList.length-1;i++)
			if(charList[i]==charList[i+1])
				return false;
		
		return true;
		
		
	}
	
	//Extra memory used but its O(k) = O(1). time O(n)
	public boolean hasAllUniqueCharacters2(String s) {
		
		if(s==null || s.length()<2)
			return true;
		
		int[] charList = new int[256];
		
		for(int i=0;i<s.length();i++) {
			int val = s.charAt(i);
			if(charList[val]>0)
				return false;
			charList[val]++;
		}
		
		return true;
	}

}
