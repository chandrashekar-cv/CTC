package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
Different words in paragraph are always separated by a space.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
*/

public class MostCommonWord {

	public static void main(String[] args) {
		MostCommonWord sol = new MostCommonWord();
		System.out.println(sol.mostCommonWord("Jack and jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.", new String[] {"and","he","the","to","is","jack","jill"}));

	}
	public String mostCommonWord(String paragraph, String[] banned) {
		
		List<String> ans = new ArrayList<>();
		String result = null;
		int maxCount = Integer.MIN_VALUE;
		Set<String> bannedSet = new HashSet<String>(Arrays.asList(banned));
		String[] tokens = paragraph.trim().split("[\\s\\.,;!\\?']+");
		HashMap<String, Integer> count = new HashMap<>();
		
		for(String token: tokens) {
			
			String cleanToken = cleanToken(token);
			if(bannedSet.contains(cleanToken))
				continue;
			Integer val = count.get(cleanToken);
			if(val==null)
				val =0;
			val++;
			if(val>maxCount) {
				maxCount = val;
				result = cleanToken;
			}
			count.put(cleanToken, val);
		
		}
		
		for(Entry<String,Integer> e: count.entrySet())
			if(e.getValue()==maxCount)
				System.out.println(e.getKey());
		
		
		return result;
        
    }
	
	public String cleanToken(String token) {
		token = token.trim().toLowerCase();
		int pos = token.indexOf("'");
		pos = pos>0?pos:token.length();
		return token.substring(0,pos);
	}
	
	

}
