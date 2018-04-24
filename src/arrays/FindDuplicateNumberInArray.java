package arrays;

public class FindDuplicateNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Idea is to consider the values in the array as pointers to index in the array making a psuedo linked list.
	//Given a value repeats in the array, this will make it a cycle.
	
	public int findDuplicate(int[] nums) {
		int slow=nums[0];
		int fast=nums[0];
		do {
			
			slow = nums[slow];
			fast = nums[nums[fast]];
			
		}while (slow!=fast);
		
		int ptr1 = nums[0];
		int ptr2 = slow;
		
		while(ptr1!=ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		
		return ptr1;
		
    }
}
