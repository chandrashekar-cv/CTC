package chapter2;

import java.util.Stack;

public class Add2Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		ListNode ptr = l1;
		while(ptr!=null) {
			stack1.push(ptr.val);
			ptr=ptr.next;
		}
		
		ptr = l2;
		while(ptr!=null) {
			stack2.push(ptr.val);
			ptr=ptr.next;
		}
		
		int carry = 0;
		ListNode root = new ListNode(0);
		
		while(!stack1.isEmpty()|| !stack2.isEmpty()) {
			int v1 = stack1.isEmpty() ? 0: stack1.pop();
			int v2 = stack2.isEmpty() ? 0: stack2.pop();
			
			int sum = v1+v2+carry;
			root.val = sum%10;
			carry = sum/10;
			ListNode next = new ListNode(0);
			next.next = root;
			root=next;
			
		}
		
		if(carry>0)
			root.val=carry;
		
		return root.val==0? root.next: root;
		
    }

}
