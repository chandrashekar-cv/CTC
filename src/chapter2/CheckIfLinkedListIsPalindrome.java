package chapter2;

import java.util.Stack;

public class CheckIfLinkedListIsPalindrome {

	public static void main(String[] args) {
		LinkedListNode a1 = new LinkedListNode(1);
		LinkedListNode a2 = new LinkedListNode(1);
		a1.next = a2;
		
		System.out.println(checkPalindrome(a1));
	}
	
	public static boolean checkPalindrome(LinkedListNode node) {
		
		if(node == null)
			return false;
		
		Stack<Integer> data = new Stack<Integer>();
		
		//Start runner from dummy node;
		LinkedListNode runner = new LinkedListNode(0);
		runner.next = node;
		LinkedListNode skipper = node;
		
		while(skipper!=null && skipper.next!=null) {
			runner = runner.next;
			data.push(runner.data);
			skipper = skipper.next.next;
		}
		//Go to 2nd half of linkedList
		runner = runner.next;
		
		//Odd number of elements in list. Skip the middle element
		if(skipper!=null)
			runner = runner.next;
		
		while(data.size()>0 && runner!=null) {
			if(data.pop()!=runner.data)
				return false;
			runner = runner.next;
		}
		
		return true;
	}

}
