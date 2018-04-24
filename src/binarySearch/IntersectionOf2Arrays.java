package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

*
*/

public class IntersectionOf2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> result = new HashSet<Integer>();
		
		//Heap sort to be used with O(n logn) time  + O(1) space
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int index1 = 0;
		int index2 = 0;
		 while(index1<nums1.length && index2<nums2.length) {
			 if(nums1[index1]==nums2[index2]) {
				 result.add(nums1[index1]);
				 index1++;
				 index2++;
			 }
			 else if(nums1[index1]< nums2[index2])
				 index1++;
			 else
				 index2++;
		 }
		 
		 int resultArray[] = new int[result.size()];
		 int i=0;
		 for(int key: result)
			 resultArray[i++] = key;
		return resultArray;
	}
	
	
	
	public int binarySearch(int[] parent, int key) {
		int low = 0;
		int high = parent.length-1;
		
		while(low<=high) {
			int mid = low+(high-low)/2;
			
			if(parent[mid]==key)
				return mid;
			
			else if(key < parent[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		
		return -1;
	}
	
	
	//Using a hashSet we can do this in O(m + n). 
	//Add all elements of the shorter array into a hashset and iterate through the longer array to find if that element is present in the hashset.
	//If present then add to the result.
	

}
