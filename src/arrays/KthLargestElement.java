package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		KthLargestElement sol = new KthLargestElement();
		
		System.out.println(sol.findKthLargest2(new int[] {3,2,1,5,6,4}, 2));

	}

	public int findKthLargest2(int[] nums, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1,Integer i2) {
				return i1-i2;
			}
		});
		
		for(int i=0;i<nums.length;i++) {
			minHeap.offer(nums[i]);
			
			if(minHeap.size()>k)
				minHeap.poll();
		}
		
		return minHeap.peek();
		
    }

	
	public int findKthLargest(int[] nums, int k) {
		
		int i =1;
		while(i<=k) {
			heapify(nums, nums.length-i);
			swap(nums,0,nums.length-i);
			i++;
		}
		
		return nums[nums.length-k];
		
    }
	
	void heapify(int[] nums, int size) {
		for(int i=size/2; i>=0;i--) {
			maxHeap(nums,i,size);
		}
	}
	
	void maxHeap(int[] nums, int i, int size) {
		int left = 2*i+1;
		int right = 2*i+2;
		int max = i;
		
		if(left<=size && nums[left] > nums[max])
			max = left;
		
		if(right<=size && nums[right] > nums[max])
			max = right;
		
		if(max!=i) {
			swap(nums,max,i);
			maxHeap(nums, max, size);
		}
	}
	
	void swap(int nums[], int max, int i) {
		int temp = nums[max];
		nums[max] = nums[i];
		nums[i] = temp;
	}

}
