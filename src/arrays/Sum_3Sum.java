package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum_3Sum {

	public static void main(String[] args) {
		Sum_3Sum sol = new Sum_3Sum();
		List<List<Integer>> res = sol.threeSum(new int[] {-1,0,1,2,-1,-4});
		System.out.println(res.size());
		

	}
	
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		//Sort the array to keep order in elements and identify which pointer to move.
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length;i++) {
			
			if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
	            continue;
	        }
			
			int j=i+1;
			int k = nums.length-1;
			
			int target = -nums[i];
			
			while(j<k) {
				
				int sum = nums[j]+nums[k];	
				
				if(sum < target)
					j++; //since array is in ascending order and sum < target, we need to include a larger number to the sum. So j++
				else if(sum > target)
					k--; // sum exceeds target. Remove the largest number in the sum add the previous one so k--
				else {
					//triplets found
					String key = String.valueOf(nums[i])+"_"+String.valueOf(nums[j])+"_"+String.valueOf(nums[k]);
					List<Integer> triplet = new ArrayList<>();
					triplet.add(nums[i]);
					triplet.add(nums[j]);
					triplet.add(nums[k]);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
	                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
	                result.add(triplet);
					
				}
					
			}
			
		}
		
		
		return result;
    }
	

}
