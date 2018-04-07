package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsOfPinS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllAnagramsOfPinS sol = new AllAnagramsOfPinS();
		
		List<Integer> res = sol.findAnagrams("cbaebabacd","abc");
		System.out.println(res);
		
	}
	
	public HashMap<Integer, Integer> getCount(String p){
		HashMap<Integer,Integer> countMap = new HashMap<>();
		
		for(int i=0;i<p.length();i++) {
			int index = p.charAt(i);
			Integer count =countMap.get(index);
			if(count == null)
				count =0;
			countMap.put(index, count+1);
		}
		
		return countMap;
	}
	
	public List<Integer> findAnagrams(String s, String p){
		
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer,Integer> count = getCount(p);
		
		//Indicates the number of unique characters in P and all the instance of each unique character is present in the sliding window
		int matchCount = 0;
		
		for(int i=0;i<s.length();i++) {
			
			int index = s.charAt(i);
			Integer value = count.get(index);
			if(value!=null) {
				if(value == 1)
					//If all but one instance of a particular character is present in the sliding window and this is the last 
					//instance of that character that should have matched, then increment the matchCount to indicate all instance of a Unique char in P
					//is present in the sliding window
					matchCount++;
				count.put(index, value-1);
			}
			
			if(i>=p.length()) {
				int leftCharInWindow = s.charAt(i-p.length());
				value = count.get(leftCharInWindow);
				if(value!=null) {
					if(value==0)
						//If all the instance of a charater in P were present in the sliding window and 
						//one particular instance is moving out of the window because of the shift, 
						//then decrement matchCount to show that all instances of the unique character is not present in the sliding window.
						matchCount--;
					count.put(leftCharInWindow, value+1);
				}
				
			}
			
			if(matchCount==count.size()) {
				//If all instances of all unique characters are present in the sliding window,
				//Add index of left most character in the sliding window.
				
				result.add(i-p.length()+1);
			}
			
		}
		
		
		return result;
		
	}
	

}
