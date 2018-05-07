package strings;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		LongestPalindromicSubString sol = new LongestPalindromicSubString();
		System.out.println(sol.longestPalindrome("abacdfgdcaba"));

	}
	
	public String longestPalindrome(String s) {
		int start=0, end=0;
		
		for(int i=0;i<s.length();i++) {
			int len1 = expandAroundCenter(s,i,i);
			int len2 = expandAroundCenter(s,i,i+1);
			
			int length = Math.max(len1, len2);
			
			if(length>(end-start+1)) {
				start = i- (length-1)/2;
				end = i+ (length/2);
			}
		}
		
		return s.substring(start, end+1);
        
    }
	
	public int expandAroundCenter(String s, int left, int right) {
		while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		
		return right-left-1;
	}
	
	/*public String dynamicProgrammingSolution(String s) {
		String res = null;
		int start = 0;
		int end = 0;
		boolean isPalindrome[][] = new boolean[s.length()][2];
		
		for(int i=s.length()-1;i>=0;i--) {
			for(int j=i;j<s.length();j++) {
				
				isPalindrome[i][j] = s.charAt(i)==s.charAt(j) && (isPalindrome[i+1][j-1])
				
			}
		}
		
		
		for(int i=0;i<s.length();i++) {
			for(int j=i;j>=0;j--) {
				isPalindrome[i][j] = isPalindrome[i+1][j-1]
			}
		}
		
		
		return res;
	}*/

}
