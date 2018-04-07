package strings;

public class LengthOfLastWord {

	public static void main(String[] args) {
		LengthOfLastWord sol = new LengthOfLastWord();
		System.out.println(sol.lengthOfLastWord2(" aa "));

	}
	
	public int lengthOfLastWord(String s) {
		s=s.trim();
		if(s==null || s.isEmpty())
			return 0;
		
		int indexOfLastSpace = -1;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ')
				indexOfLastSpace =i;
		}
		
		return (s.length()-1)-indexOfLastSpace;
		
		
	}
	
	
	public int lengthOfLastWord2(String s) {
		if(s==null || s.isEmpty())
			return 0;
		
		int i=s.length()-1;
		
		while(i>=0 && s.charAt(i)==' ')
			i--;
		
		if(i<0)
			return 0;
		
		int length = 0;
		
		while(i>=0 && s.charAt(i)!=' ') {
			length++;
			i--;
		}
		
		return length;
		
	}

}
