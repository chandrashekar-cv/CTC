package chapter2;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?*/

public class LinkedListCycleDetectionII {

	public static void main(String[] args) {
		

	}
	 public ListNode detectCycle(ListNode head) {
		 
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 while(slow !=null && fast!=null && fast.next!=null) {
			 
			 slow = slow.next;
			 fast = fast.next.next;
			 
			 if(slow == fast)
				 return getLoopStart(head,slow);
			 
		 }
		 
		 return null;
	        
	 }
	 
	 ListNode getLoopStart(ListNode start, ListNode slow) {
		 while(start!=slow) {
			 slow = slow.next.next;
			 start = start.next;
			 
		 }
		 
		 return slow;
	 }
}
