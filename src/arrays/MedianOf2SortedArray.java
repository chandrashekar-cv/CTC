package arrays;

public class MedianOf2SortedArray {

	public static void main(String[] args) {
		System.out.println(new MedianOf2SortedArray().findMedianSortedArrays2(new int[] {1,3},new int[] {0,2}));

	}
	
	double median(int[]X, int start, int end) {
		int len = end-start+1;
		int mid = (end-start+1)/2;
		if(len%2==1)
			return X[mid];
		else
			return (X[mid]+X[mid+1])/2.0;
	}
	
	public  float findMedianSortedArrays(int[] A, int[] B) {
		
		
		
		
		int leftA = 0,rightA = A.length-1;
		int leftB = 0,rightB = B.length-1; 
		
		
		while(true) {
			int midA = (leftA+rightA)/2;
			int midB = (leftB+rightB)/2;
			
			double medianA=median(A, 0, A.length-1);
			double medianB=median(B,0,B.length-1);
			
			if(medianA<medianB) {
				leftA = midA;
			}
			else if(medianA>medianB) {
				rightA = midA;
			}
			else
				return (float) ((medianA+medianB)/2.0);
			
		}
	}
	
	
	public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
	
}
