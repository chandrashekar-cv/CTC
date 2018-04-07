package chapter3;

import java.util.Stack;

public class MinStack{
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
		stack.push(x);
		pushMinStack(x);
	}
	
	public void pop() {
		if(stack.isEmpty())
			return;
		
		int x = stack.pop();
		popMinStack(x);
	}
	
	public Integer top() {
		if(stack.isEmpty())
			return null;
		
		return stack.peek();
	}
	
	public Integer getMin() {
		if(minStack.isEmpty())
			return null;
		
		return minStack.peek();
		
	}

	
	public void pushMinStack(int x) {
		int min = getMin();
		if(x<=min)
			minStack.push(x);
	}
	
	public void popMinStack(int x) {
		int min = getMin();
		
		if(min>=x)
			minStack.pop();
		
	}
	
}
