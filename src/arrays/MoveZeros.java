package arrays;

import java.math.BigInteger;
import java.util.HashSet;


public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(containsNearbyDuplicate(new int[] {2147483647,-2147483647},1,2147483647));
		
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length<2)
            return false;
        
        HashSet<Integer> data = new HashSet<Integer>();
        
        int i=0;
        for(;i<k && i< nums.length;i++){
            if(findTDiff(data,nums[i],t))
                return true;
            data.add(nums[i]);
        }
        
        for(;i<nums.length;i++){
            if(findTDiff(data,nums[i],t))
                return true;
            data.add(nums[i]);
            data.remove(nums[i-k]);
        }
        
        return false;
        
    }
	
	static boolean findTDiff(HashSet<Integer> data,int val, int diff) {
		BigInteger t = new BigInteger(String.valueOf(diff));
		BigInteger val1 = new BigInteger(String.valueOf(val));
		for(int v: data) {
			BigInteger v1 = new BigInteger(String.valueOf(v));
			if(t.compareTo(v1.subtract(val1).abs())>=0)
				return true;
		}
		return false;
	}
	 
}
