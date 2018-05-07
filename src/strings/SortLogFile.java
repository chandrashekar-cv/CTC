package strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortLogFile {

	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		data.add("fhie 1df8 sfds");
		data.add("fdsf 2def sees");
		data.add("efe2 br9o fjsd");
		data.add("asd1 awer jik9");
		
		SortLogFile sol = new SortLogFile();
		sol.sortFile(data);
		
		for(String s: data)
			System.out.println(s);

	}
	
	public List<String> sortFile(List<String> lines){
		
		lines.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				 String s1Tokens = s1.substring(s1.indexOf(" "),s1.length());
		            String s2Tokens = s2.substring(s2.indexOf(" "),s2.length());
		            
		            int size = Math.min(s1Tokens.length(),s2Tokens.length());
		            
		            for(int i=1;i<size;i++){
		                char c1 = s1Tokens.charAt(i);
		                char c2 = s2Tokens.charAt(i);
		                
		                if((!Character.isDigit(c1) && !Character.isDigit(c2))||
		                    (Character.isDigit(c1) && Character.isDigit(c2))){
		                    if(c1!=c2)
		                        return c1-c2;
		                }
		                else if(Character.isDigit(c1)){
		                    return 1;
		                }
		                else if(Character.isDigit(c2)){
		                    return -1;
		                }
		            }
		            
		            String id1 = s1.substring(0,s1.indexOf(" "));
		            String id2 = s2.substring(0,s2.indexOf(" "));
		            
		            for(int i=0;i<Math.min(id1.length(),id2.length());i++){
		                char c1 = id1.charAt(i);
		                char c2 = id2.charAt(i);
		                if((!Character.isDigit(c1) && !Character.isDigit(c2))||
		                    (Character.isDigit(c1) && Character.isDigit(c2))){
		                    if(c1!=c2)
		                        return c1-c2;
		                }
		                else if(Character.isDigit(c1)){
		                    return 1;
		                }
		                else if(Character.isDigit(c2)){
		                    return -1;
		                }
		            }
		            
		            return s1.length()-s2.length();
			}
		});
		
		return lines;
	}

}
