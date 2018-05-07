package strings;

public class LongestCommonSubString {

	public static void main(String[] args) {
		LongestCommonSubString sol = new LongestCommonSubString();
		System.out.println(sol.longestCommonSubString2("GeeksforGeeks","QuizGeeksfQuiz"));

	}
	
	public int longestCommonSubString(String s, String p) {
		
		int m= s.length();
		int n= p.length();
		int result = 0;
		int[][] suffixLength = new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || j==0)
					suffixLength[i][j]=0;
				else if(s.charAt(i-1)==p.charAt(j-1)) {
					suffixLength[i][j] = suffixLength[i-1][j-1]+1;
					if(result<suffixLength[i][j])
						result = suffixLength[i][j];
				}
				else {
					suffixLength[i][j] = 0;
				}
			}
		}
		
		return result;
	}
	
	public int longestCommonSubString2(String s, String p) {
		
		int m= s.length();
		int n= p.length();
		Cell result = new Cell(0,'$', null);
		Cell[][] suffixLength = new Cell[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || j==0)
					suffixLength[i][j]=new Cell(0,s.charAt(i),null);
				else if(s.charAt(i-1)==p.charAt(j-1)) {
					Cell previous = suffixLength[i-1][j-1];
					suffixLength[i][j].length = previous.length+1;
					suffixLength[i][j].parent = previous;
					if(result.length<suffixLength[i][j].length)
						result = suffixLength[i][j].parent;
				}
				else {
					suffixLength[i][j] = new Cell(0, s.charAt(i), null);
				}
			}
		}
		StringBuilder x = new StringBuilder();
		while(result!=null) {
			x.insert(0, result.c);
		}
		System.out.println(x.toString());
		
		return result==null? 0: result.length;
	}

}

class Cell{
	public Cell(int i, char charAt, Cell object) {
		length = i;
		c = charAt;
		parent = object;
	}
	int length;
	char c;
	Cell parent;
}
