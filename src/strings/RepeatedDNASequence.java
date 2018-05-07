package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

public class RepeatedDNASequence {

	public static void main(String[] args) {
		RepeatedDNASequence sol = new RepeatedDNASequence();
		System.out.println(sol.findRepeatedDnaSequences("AAAAAAAAAAAA"));
		
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        
		List<String> sequence = new ArrayList<String>();
		HashMap<Integer,Integer> intSequnce = new HashMap<Integer,Integer>();
		
		int[] charHash = new int[26];
		
		charHash['A'-'A'] = 0;
		charHash['C'-'A'] = 1;
		charHash['G'-'A'] = 2;
		charHash['T'-'A'] = 3;
		
		int mask = (int) (Math.pow(2, 20) - 1);
		
		int value = 0;
		
		for(int i=0;i<s.length();i++) {
			
			char character = s.charAt(i);
			int hashValue = charHash[character-'A'];
			value = value<<2;
			value = value|hashValue;
			if(i>=9) {
				
				value = value & mask;
				
				Integer count = intSequnce.get(value);
				if(count==null)
					count =0;
				count++;
				if(count==2)
					sequence.add(s.substring(i-9, i+1));
				intSequnce.put(value, count);
				
			}
				
		}
		
		return sequence;

    }

}
