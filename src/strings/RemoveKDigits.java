package strings;

import java.util.Stack;

/*Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.*/

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
