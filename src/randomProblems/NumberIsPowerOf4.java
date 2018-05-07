package randomProblems;

public class NumberIsPowerOf4 {

	public static void main(String[] args) {
		NumberIsPowerOf4 sol = new NumberIsPowerOf4();
		int max=1;
		while((max*3)>max)
            max=max*3;
		
		System.out.println(max);
		System.out.println(sol.isPowerOfFour(0));

	}
	
	 public boolean isPowerOfFour(int num) {
		    
		 if(num < 0 || (num & (num-1))!=0)
			 return false;
		        
		 int zeroCount = 0;
		 while(num>1){
			 num=num>>1;
			 zeroCount++;
		 }
		        
		 return zeroCount%2==0;       
	        
	  }
	
}
