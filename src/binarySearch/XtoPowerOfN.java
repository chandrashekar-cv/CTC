package binarySearch;

public class XtoPowerOfN {

	public static void main(String[] args) {
		XtoPowerOfN sol = new XtoPowerOfN();
		System.out.println(sol.myPow(2, 10));

	}
	
	 public double myPow(double x, int n) {
	
	 if(n==0)
		 return 1;
	 else if(n==1)
		 return x;
	 else if(n==-1)
		 return 1/x;
	 
	 return reccursiveCalculation(x, n);
	 }
	 
	 public double reccursiveCalculation(double x, int n) {
		 if(n==0)
			 return 1;
		 else if(n==1)
			 return x;
		 else if(n==-1)
			 return 1/x;
		 else {
			 double xPowNby2 = reccursiveCalculation(x, n/2);
			 double result = xPowNby2*xPowNby2;
			 if(n%2==1)
				 return result *x;
			 else if(n%2==-1)
				 return result*(1/x);
			 else
				 return result;
		 }
		 
	 }

}
