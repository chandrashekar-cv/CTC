package arrays;

import java.util.ArrayList;
import java.util.Stack;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addOne(new int[] {9,0,9}));
		
	}
	
	
	static int[] addOne(int[] a) {
		
		
		for(int i=a.length-1;i>=0;i--) {
			if(a[i]<9) {
				a[i]++;
				return a;
			}
			a[i] = 0;
		}
		
		int[] res = new int[a.length+1];
		res[0]=1;
		return res;
		
	}
		 
	
	
	

}
