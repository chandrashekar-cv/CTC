package binarySearch;
/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
*/
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
		System.out.println(sol.search(new int [] {4,5,6,7,0,1,2,3}, 6));

	}
	
	 public int search(int[] nums, int target) {
	 
		 if(nums==null || nums.length==0)
			 return -1;
		 
		 int low = 0;
		 int high = nums.length-1;
		 
		 int root = findRoot(nums);
		 
		 while(low<=high) {
			 int psuedoMid = low + (high-low)/2;
			 
			 int mid = (psuedoMid+root)%nums.length;
			 
			 if(nums[mid]==target)
				 return mid;
			 
			 if(target<nums[mid])
				 high = psuedoMid-1;
			 else
				 low = psuedoMid+1;
			 
		 }
		 
		 return -1;
	 }
	 
	 public int findRoot(int[] nums) {
		 int low = 0;
		 int high = nums.length-1;
		 
		 while(low<=high) {
			 
			int mid = low + (high-low)/2;
			 if(nums[mid]>=nums[low])
				 low = mid+1;
			 else
				 high = mid;
		 }
		 return low;       
	 }
	 

}
