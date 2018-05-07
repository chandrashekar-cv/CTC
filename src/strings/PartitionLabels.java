package strings;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		PartitionLabels sol = new PartitionLabels();
		List<Integer> res = sol.partitionLabels("ababcbacadefegdehijhklij");
		
		for(int e: res)
			System.out.print(e);
			

	}
	
	public List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<Integer>();
		
		int[] charPositions = new int[26];
		for(int i=0;i<S.length();i++) {
			charPositions[S.charAt(i)-'a'] = i;
		}
		
		
		int start =0;
		int end =0;
		
		for(int i=0;i<S.length();i++) {
			end = Math.max(end, charPositions[S.charAt(i)-'a']);
			if(end == i) {
				result.add(end-start+1);
				start = i+1;
			}
		}
		
		return result;
		
    }

}
