package strings;

public class RemoveAdjacentRepeatedChars {

	public static void main(String[] args) {
		RemoveAdjacentRepeatedChars sol = new RemoveAdjacentRepeatedChars();
		
		System.out.println(sol.removeDuplicateLetters("abbccdef"));

	}
	
	
	public String removeDuplicateLetters(String s) {
		
		if(s==null || s.length()==0)
			return s;
		
		char[] characters= s.toLowerCase().toCharArray();
		int slow = 1;
		int fast = 1;
		
		while(fast<characters.length) {
			
			if(characters[slow-1]==characters[fast]) {
				fast++;
			}
			else {
				characters[slow++] = characters[fast++];
			}	
		}
		
		
		return String.valueOf(characters,0,slow);
    }

}
