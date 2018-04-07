package algos;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mrg = new MergeSort();
		
		int []nums = new int[10000];
		
		Random rand = new Random();
		
		for(int i=0;i<nums.length;i++)
			nums[i] = rand.nextInt(10000);
		
		int[] res = mrg.mergesort(nums, 0, nums.length-1);
		System.out.println(res);
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
			if(b[i]<c[j])
				a[k++] = b[i++];
			else if(b[i]>c[j])
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
