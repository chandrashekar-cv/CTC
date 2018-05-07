package randomProblems;

import java.util.Stack;

/*
 * given an array of strings. number means the scores you get, 
 * X means current score is previou's score*2, 
 * + means current score is previous two score's sum, 
 * Z means remove previous score. 
 * then return the sum of the final scores
eg. input 
["5", "-2", "4", "Z", "X", 9, "+", "+"]


output 27
5 : sum = 5
-2 : sum = 5 - 2 = 3. 
4 : sum = 3 + 4 = 7
Z : sum = 7 - 3 = 4
X : sum = 3 + -2 * 2 = -1  (since 4 is remvoed, previous score is -2)
+ : sum = 8 + 9 - 4 = 13 (previous two scores are 9 and -4)
+ : sum = 13 + 9 + 5 = 27 (previosu two scores are 5 and 9)

*/
public class ArrayOfStringsWithOperations {

	public static void main(String[] args) {
		ArrayOfStringsWithOperations sol = new ArrayOfStringsWithOperations();
		
		System.out.println(sol.process(new String[] {"5", "-2", "4", "Z", "X", "9", "+", "+"}));

	}
	
	public int process(String[] value) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<value.length;i++) {
			if("+".equals(value[i])) {
				int prev = stack.isEmpty()?0:stack.pop();
				int prev2 = stack.isEmpty()?0: stack.pop();
				stack.push(prev);
				stack.push(prev+prev2);
			}
			else if("X".equals(value[i])) {
				int prev=stack.isEmpty()?0:stack.peek();
				stack.push(prev*2);
			}
			else if("Z".equals(value[i])) {
				if(!stack.isEmpty())
					stack.pop();
			}
			else {
				stack.push(Integer.parseInt(value[i]));
			}
		}
		
		return stack.isEmpty()?0:stack.peek();

	}

}
