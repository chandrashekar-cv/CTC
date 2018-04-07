package strings;

import java.util.Arrays;
import java.util.Stack;

public class RemoveAdjacentRepeatedChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String removeDuplicateLetters(String s) {
		s= s.toLowerCase();
		
		char[] charList = s.toCharArray();
		Stack<Character> orderedList = new Stack<Character>();
		int[] count = new int[26];
		
		
		for(char c: charList)
			count[c-'a']++;
		
		
		
		//boolean[] visited = new boolean[];
		
		return null;
    }

}
