package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		RemoveKDigits sol = new RemoveKDigits();
		
		System.out.println(sol.removeKdigits3("10", 1));

	}
	
	public String removeKdigits2(String num, int k) {
		
		if(num.length()<=1 & k>=1)
			return "0";
		
		StringBuilder builder = new StringBuilder();
		int i=0,j=1;
		
		while(j<num.length() && k > 0) {
			if(num.charAt(i) <= num.charAt(j)) {
				builder.append(num.charAt(i));
				
			}
			else
				k--;
			i++;
			j++;
		}
		
		while(i<num.length())
			builder.append(num.charAt(i++));
		
		int start= 0;
		while(start < builder.length() && builder.charAt(start)=='0')
			start++;
		
		if( start >= builder.length() -k || builder.length()<=k)
			return "0";
		
		
		return builder.substring(start, builder.length()-k);
		//doesn't work for 1234567890
    }
	
	
	public String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<num.length();i++) {
			char c = num.charAt(i);
			
			while(k>0 && !stack.isEmpty() && stack.peek() > c) {
					stack.pop();
					k--;
			}
			stack.push(c);
		}
		
		StringBuilder result = new StringBuilder();
		
		if(stack.size()<=k)
			return "0";
		
		while(k>0) {
			stack.pop();
			k--;
		}
			
		
		while(!stack.isEmpty()) {
			result.insert(0, stack.pop());
		}
		int start=0;
		while(start < result.length() && result.charAt(start)=='0')
			start++;
		
		
		return start == result.length()? "0":result.substring(start, result.length());
	}
	
	
	public String removeKdigits3(String num, int k) {
		char[] digits = new char[num.length()];
		int top = -1;
		
		for(int i=0;i<num.length();i++) {
			char c = num.charAt(i);
			while(top>=0 && digits[top] > c && k>0) {
				top--;
				k--;
			}
			digits[++top] = c; 
		}
		
		top = top-k;
		int start = 0;
		while(start <= top && digits[start]=='0')
			start++;
		
		return start>top?"0": new String(digits,start,top-start+1); 
		
			
		
	}

}
