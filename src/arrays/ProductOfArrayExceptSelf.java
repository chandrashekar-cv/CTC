package arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		
		ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();
		sol.productExceptSelf(new int[] {1,2,3,4,5});

	}
	
	public int[] productExceptSelf(int[] nums) {
		
		if (nums.length<2)
			return nums;
		int[] output = new int[nums.length];
		
		if(nums.length==2) {
			int temp = nums[0];
			nums[0]=nums[1];
			nums[1]=temp;
			return nums;
		}
		
		int i=0;
		int j = nums.length-1;
		
		int leftProd = nums[i];
		int rightProd =  nums[j];
		
		for(i=1;i<nums.length/2;i++) {
			j = nums.length-i-1;
			
			leftProd = leftProd*nums[i];
			rightProd = rightProd*nums[j];
			
			nums[i] = leftProd;
			nums[j] = rightProd;
			
		}
		
		while(i<j) {
			nums[i] = nums[i]*nums[i-1];
			i++;
		}
	
		while(i+1<nums.length) {
			j=nums.length-1-i;
			output[i] = nums[i-1]*nums[i+1];
			output[j] = nums[j-1]*nums[j+1];
			
		}
		return nums;
    }

}
