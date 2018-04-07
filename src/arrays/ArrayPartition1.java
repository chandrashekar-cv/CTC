package arrays;

import java.util.Arrays;

public class ArrayPartition1 {

	
	public int arrayPairSum(int[] nums) {
		int minSum = 0;
		long start  = System.currentTimeMillis();
		Arrays.sort(nums);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000);
		nums = mergesort(nums, 0, nums.length-1);
		for(int i=nums.length-2;i>=0;i-=2) {
			minSum+=nums[i];
		}
		return minSum;
    }
	
	int[] mergesort(int a[], int low, int high) {
		if(low==high)
			return new int[] {a[low]};
		
		int mid = low+(high-low)/2;
		int[] b= mergesort(a, low, mid);
		int[] c= mergesort(a, mid+1, high);
		a = merge(b,c);
		
		return a;
	}
	
	int[] merge(int []b,int []c) {
		int[] a = new int[b.length+c.length];
		
		int i=0,j=0,k=0;
		while(i<b.length && j<c.length) {
			if(b[i]>c[j])
				a[k++] = b[i++];
			else if(b[i]<c[j])
				a[k++] = c[j++];
			else {
				a[k++] = b[i++];
				a[k++] = c[j++];
			}
				
		}
		
		while(i<b.length)
			a[k++] = b[i++];
		
		while(j<c.length)
			a[k++] = c[j++];
		
		return a;
	}
	
	
}
