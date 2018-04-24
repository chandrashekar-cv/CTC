package randomProblems;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		ExcelSheetColumnNumber sol = new ExcelSheetColumnNumber();
		sol.titleToNumber("AA");

	}
	
	public int titleToNumber(String s) {
		
		int num = 0;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			num = num*26 + (c-'A'+1); 
		}
        return num;
    }

}
