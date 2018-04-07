package chapter3;

import java.util.Stack;

public class StackOfStacks {
	public StackOfStacks(int maxSize) {
		this.maxSize = maxSize;
	}
	
	Stack<Stack> stackList = new Stack<>();
	int maxSize;
	int elementCount = 0;
	
	
	void push(int item) {
		Stack stack;
		if(stackList.isEmpty()) {
			stack = new Stack<>();
			stackList .push(stack);
		}
		else
			stack = stackList.peek();
		
		if(stack.size() == this.maxSize) {
			stack = new Stack();
			stackList.push(stack);
		}
		
		stack.push(item);
		elementCount++;
			
	}
	
	Integer peek() {
		
		Stack stack = getStack();
		
		if(stack==null)
			return null;
		
		return (Integer) stack.peek();
		
	}
	
	Integer pop(){
		Stack stack = getStack();
		
		if(stack == null)
			return null;
		
		elementCount--;
		
		int res = (int) stack.pop();
		
		if(stack.size()==0)
			stackList.pop();
		
		return res;
	}
	
	Stack getStack() {
		Stack stack = null;
		if(stackList.isEmpty())
			return stack;
		
		while(!stackList.isEmpty()) {
			stack = stackList.peek();
			if(stack.size()>0)
				break;
			else
				stackList.pop();
		}
		return stack;
	}
	
	
	Integer popAt(int i) {
		if(i>elementCount || stackList.isEmpty())
			return null;
		
		int stackPosition = i/this.maxSize;
		
		Stack<Stack<Integer>> intermediate = new Stack<Stack<Integer>>();
		for(int j=0;j<stackPosition; j++) {
			intermediate.push(stackList.pop());
		}
		
		Stack<Integer> stack = intermediate.pop();
		
		Stack<Integer> valueHolder = new Stack<Integer>();
		for(int j=0;j<i%this.maxSize;j++) {
			valueHolder.push((Integer) stack.pop());
		}
		
		int popElement = valueHolder.pop();
		
		//bring elements back in order
		while(!valueHolder.isEmpty())
			stack.push(valueHolder.pop());
		
		//start shifting elements from lower stacks
		
		while(!stackList.isEmpty()) {
			
			Stack shifter = stackList.pop();
			
			while(valueHolder.size()<this.maxSize) {
				valueHolder.push((Integer) shifter.pop());
			}
			
			intermediate.push(valueHolder);
			valueHolder = shifter;
		}
		
		
		if(intermediate.peek().size()==0)
			intermediate.pop();

		//Intermediate stack is reverse representation of original stackList. reverse it back to original stackList
		while(!intermediate.isEmpty())
			stackList.push(intermediate.pop());
		
		return popElement;
	}
	
	
}
