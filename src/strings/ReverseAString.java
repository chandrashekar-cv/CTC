package strings;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Using string builder
	 public String reverseString(String s) {
	       if(s==null)
	    	   	return s;
	       StringBuilder res = new StringBuilder();
	       for(int i=s.length()-1;i>=0;i--) {
	    	   	res.append(s.charAt(i));
	       }

	       return res.toString();
	       
	 }
	 
	 //in palce
	 public String reverse2(String s) {
		 char[] res = s.toCharArray();
		 int left = 0;
		 int right = s.length()-1;
		 
		 while(left<right) {
			 char temp = res[left];
			 res[left] = res[right];
			 res[right] = temp;
		 }
		 return String.valueOf(res);
	 }

}
