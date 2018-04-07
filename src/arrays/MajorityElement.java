package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int majorityElement(int[] nums) {
		
		Arrays.sort(nums);
		
		return nums[nums.length/2];
		
		
	}
	

}
