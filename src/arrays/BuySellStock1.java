package arrays;

import java.util.Stack;

public class BuySellStock1 {

	public static void main(String[] args) {
		
		System.out.println(maxProfit(new int[] {3,3}));
	}
	
	public static int maxProfit(int[] prices) {
    
 
		
		if(prices==null || prices.length<2)
			return 0;
		boolean buy = false;
		int i=1;
		
		int buyPrice = 0,sellPrice = 0;
		int profit = 0;
		
		
		
		while(i<prices.length) {
			
			if(prices[i]<=prices[i-1] && !buy) {
				i++;
			}
			else {
				if(!buy)
					buyPrice = prices[i-1];
				
				buy = true;
				
				if(prices[i] >= prices[i-1] && buy)
					i++;
				else {
					sellPrice = prices[i-1];
					profit+=(sellPrice - buyPrice);
					buy=false;
				}
			}
			
		}
		
		if(buy) {
			profit+=(prices[prices.length-1]-buyPrice);
		}
		
		
		return profit;
		
		
    }

}
