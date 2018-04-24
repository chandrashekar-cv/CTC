package binarySearch;

/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class MinimunInRotatedSortedArray {

	public static void main(String[] args) {
		MinimunInRotatedSortedArray sol = new MinimunInRotatedSortedArray();
		System.out.println(sol.findMin(new int[] {}));

	}
	 public int findMin(int[] nums) {
		 
		 if(nums == null || nums.length==0)
			 return 0;
		 int low = 0;
		 int high = nums.length-1;
		 
		 
		 while(low<=high) {
			 
			 //This means the sub array selected is sorted.
			 if(nums[low]<nums[high] || low == high)
				 return nums[low];
			 
			 int mid = low + (high-low)/2;
			 if(nums[mid]>=nums[low])
				 low = mid+1;
			 else
				 high = mid;
		 }
		 return nums[low];       
	 }
	 
	 
}
