package strings;

/*Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.*/

public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	 public int repeatedStringMatch(String A, String B) {
		 
		 
		 if(B==null || A==null)
			 return -1;
		 
		 String base = A;
		 int count = ((int)B.length()/A.length());
		 A = appendString(A, base, count);
		 
		 int iA=0;
		 int iB=0;
		 
		 boolean match = false;
		
		 while(iB<B.length()) {
			 if(match && iA>=A.length()) {
				 A=appendString(A, base, 1);
				 count++;
			 }
				 
			 if(A.charAt(iA)==B.charAt(iB)) {
				 match=true;
				 iA++;
				 iB++;
			 }
			 else {
				 if(match)
					 iB=0;
				 match=false;
			 }
			 
			 iA++;
		 }
		 
		 if(!match)
			 return -1;
		 
	     return count;   
	 }
	 
	 public String appendString(String parent,String base, int count) {
		 
		 StringBuilder result = new StringBuilder(parent);
		 for(int i=1;i<=count;i++)
			 result.append(base);
		 return parent;
	 }
	
}
