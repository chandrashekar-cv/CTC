package strings;

/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?*/

public class IsIntegerPalindrome {

	public static void main(String[] args) {
		IsIntegerPalindrome sol = new IsIntegerPalindrome();
		
		System.out.println(sol.isPalindrome(Integer.MAX_VALUE));

	}
	
	 public boolean isPalindrome(int x) {
		 
		 if(x<0)
			 return false;

		 if(x!=0 && x%10==0)
			 return false;

		 int reverseNumber = 0;
		 
		 while(x > reverseNumber){
			 int remainder = x%10;
			 reverseNumber = reverseNumber*10 + remainder;
			 x = x/10;
			 
		 }
		 
		 return x==reverseNumber || x==reverseNumber/10;
	 }
	

}
