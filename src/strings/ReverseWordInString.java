package strings;

import java.util.HashSet;
import java.util.Set;

public class ReverseWordInString {

	public static void main(String[] args) {
		ReverseWordInString sol = new ReverseWordInString();
		sol.reverseWords2(new char[] {'x','y','z',' ','a','b',' ','b','c'});
		Set<String> v = new HashSet<>();
		
		

	}
	
	public String reverseWords(String s) {
		
		s = s.replaceAll(" +", " ");
		
		String[] tokens= s.trim().split(" ");
		int left=0;
		int right = tokens.length-1;
		
		while(left<=right) {
			if(tokens[left].trim().isEmpty())
				left++;
			else if(tokens[right].trim().isEmpty())
				right--;
			else {
				String swap = tokens[left].trim();
				tokens[left] = tokens[right].trim();
				tokens[right] = swap;
				left++;
				right--;
			}
			
		}
		
		return String.join(" ", tokens);

    }
	
	public String reverseWordsOptimized(String s) {
		
		StringBuilder sb = new StringBuilder();
		String[] tokens = s.split(" ");
		for(int i=tokens.length-1;i>=0;i--)
			if(!tokens[i].isEmpty())
			sb.append(tokens[i].trim()).append(" ");
		
		return sb.toString().trim();
		
	}
	
	
	//Reverse words in string 2 -- in place swapping. Reverse the array. Then reverse individual tokens.
	public void reverseWords2(char[] str) {
		
		int left=0;
		int right=str.length-1;
		
		reverse(str, left, right);
		
		int start=0;
		int end =0;
		
		while(end<str.length) {
			if(end<str.length-1 && str[end]!=' ')
				end++;
			else {
				int tokenEnd = end==str.length-1?str.length-1: end-1;
				
				reverse(str,start,tokenEnd);
				start = end+1;
				end = start;
			}
			
		}
		
		
		System.out.println(str);
	}
	
	public void reverse(char[] str, int left,int right) {
		while(left<=right) {
			char swap = str[left];
			str[left] = str[right];
			str[right] = swap;
			left++;
			right--;
		}
		
	
	}
	
	

}
