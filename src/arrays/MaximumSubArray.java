package arrays;

public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-4,4});

	}
	
	 public static int maxSubArray(int[] nums) {
		 
		 int sum = nums[0];
		 int result = sum;
		 
		  for(int i=1;i<nums.length;i++) {
			 
			 if(sum>0) {
				 sum+=nums[i];
			 }
			 else {
			 	sum = nums[i];
			 }
			 
			 if(sum>result) {
				 result = sum;
			 }
		 }
		
		 return result;
	        
	 }
	 	 

}
