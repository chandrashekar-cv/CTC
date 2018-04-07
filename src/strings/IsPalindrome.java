package strings;

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
