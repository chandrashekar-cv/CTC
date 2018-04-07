package arrays;

import java.util.HashMap;

public class ContainsDuplicates3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
		int min = Integer.MIN_VALUE;
		int ik=0;
		int i=0;
		
		HashMap<Integer, Integer> buckets = new HashMap<>();
		
		for(;i<nums.length;i++) {
			int newVal = nums[i]-min;
			
			if(i-ik>k) {
				int val = nums[ik]-min;
				int x = val/(t+1);
				buckets.remove(x);
				ik++;
			}
			
			int x = newVal / (t+1);
			
			if(buckets.containsKey(x)
					|| (buckets.containsKey(x-1) && Math.abs(buckets.get(x-1) - newVal) <=t) 
					|| (buckets.containsKey(x+1) && Math.abs(buckets.get(x+1) - newVal) <=t))
				return true;
			
			if(!buckets.containsKey(x))
				buckets.put(x, newVal);
			
			
		}
		
		
        return false;
    }

}
