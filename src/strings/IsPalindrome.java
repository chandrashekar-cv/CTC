package strings;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

public class IsPalindrome {

	public static void main(String[] args) {
		IsPalindrome sol = new IsPalindrome();
		System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));

	}
	
	public boolean isPalindrome(String s) {
		
		if(s==null || s.length()==0)
			return true;
		
		s= s.toLowerCase();
		int left = 0;
		int right = s.length()-1;
		
		while(left<=right) {
			if(!Character.isLetterOrDigit(s.charAt(left)))
				left++;
			else if(!Character.isLetterOrDigit(s.charAt(right)))
				right --;
			else if(s.charAt(left++)!=s.charAt(right--))
					return false;
			
		}
		
		return true;
        
    }
	
	
}
