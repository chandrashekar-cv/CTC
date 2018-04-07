package arrays;

public class MedianOf2SortedArray {

	public static void main(String[] args) {
		System.out.println(new MedianOf2SortedArray().findMedianSortedArrays(new int[] {1,2},new int[] {3,4,5,6}));

	}
	
	public float singleArrayMedian(int A[],int B[]) {
		
		
		int[] v = A.length == 0? B:A;
		
		int len = v.length;
		if(v.length%2==1)
			return (float)v[(len-1)/2];
		else 
			return (float) ((v[ (len-1)/2]+v[(len-1)/2 + 1])/2.0); 
	}
	
	public  float findMedianSortedArrays(int[] A, int[] B) {
		
		if(A.length == 0 || B.length==0)
			return singleArrayMedian(A, B);
		
		if(A.length <B.length ) {
			int []temp = A;
			A=B;
			B=temp;
		}
		
		int lenA = A.length;
		int lenB = B.length;
		
		int low = 0;
		int high = lenA;
		int mid = (lenA+lenB+1)>>1;
		
		while(low<=high) {
			
			int i = (low+high)>>1;
			int j = mid - i;
			
			if( isBound(i,0, lenA-1) && isBound(j, 0, lenB-1) && B[j-1] > A[i]) {
				low = i+1;
			}
			else if(isBound(i,0, lenA-1) && isBound(j, 0, lenB-1) && A[i-1] > B[j]) {
				high = i-1;
			}
			else {
				
				int maxOnLeft = 0;
				int minOnRight = 0;
				
				if(i == 0) 
					maxOnLeft = B[lenB-1];
				else if(j==0)
					maxOnLeft = A[lenA-1];
				else maxOnLeft = Math.max(A[i-1],B[j-1]);
				
				
				if((lenA+lenB)%2==1)
					return maxOnLeft;
				
				
				if(i==lenA)
					minOnRight = B[j];
				else if(j==lenB)
					minOnRight = A[i];
				else 
					minOnRight = Math.min(A[i],B[j]);
					
				return (float) ((maxOnLeft+minOnRight)/2.0);
				
				
			}
			
			
		}
		return 0;
	}
	
	boolean isBound(int x, int min,int max) {
		return x>=min && x<=max;
	}

}
