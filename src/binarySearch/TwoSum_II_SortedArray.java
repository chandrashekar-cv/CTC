package binarySearch;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2*/

public class TwoSum_II_SortedArray {

	public static void main(String[] args) {
		TwoSum_II_SortedArray sol = new TwoSum_II_SortedArray();
		
		System.out.println(sol.twoSum(new int[] {2,7,11,15}, 9));

	}
	
	public int[] twoSum(int[] numbers, int target) {
		
		
		int left = 0;
		int right = numbers.length-1;
		
		while(left<right) {
			int sum = numbers[left]+numbers[right];
			if(target==sum)
				return new int[] {left+1,right+1};
			
			if(sum>target)
				right--;
			else
				left++;
		}
		return null;
    }

}
