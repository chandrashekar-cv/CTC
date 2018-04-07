package strings;

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
