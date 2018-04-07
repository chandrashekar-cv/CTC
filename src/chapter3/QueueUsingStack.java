package chapter3;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> newStack = new Stack<>();//Insert into new stack.
	Stack<Integer> oldStack = new Stack<>();//pop from newStack to oldStack to reverse order(Stack->Queue) and pop
	
	public void push(int x) {
		newStack.push(x);
	}
	
	public Integer pop(){
		if(this.empty())
			return null;
		
		if(oldStack.isEmpty())
			reverseOrder();
		
		return oldStack.pop();
	}
	
	public Integer peek(){
		
		if(this.empty())
			return null;
		if(oldStack.isEmpty())
			reverseOrder();
		
		return oldStack.peek();
		
	}
	
	public boolean empty() {
		return newStack.isEmpty() && oldStack.isEmpty();
	}
	
	public void reverseOrder() {
		while(!newStack.isEmpty())
			oldStack.push(newStack.pop());
	}
	
	public static void main(String[] args) {
		
		QueueUsingStack sol = new QueueUsingStack();
		sol.push(1);
		sol.push(2);
		sol.push(3);
		System.out.println(sol.pop());
		System.out.println(sol.peek());
		
		
	}

}
