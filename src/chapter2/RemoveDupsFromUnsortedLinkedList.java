package chapter2;

/*
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP
	How would you solve this problem if a temporary buffer is not allowed?
 */

public class RemoveDupsFromUnsortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public LinkedListNode deleteDups(LinkedListNode node) {
		
		if(node == null)
			return node;
		LinkedListNode cur = node.next;
		LinkedListNode prev = node;
		
		while(cur!=null) {
			if(prev.data!=cur.data) {
				prev.next = cur.next;
				
			}
			else {
				prev = cur;
			}
			cur = cur.next;
			
		}
		
		return node;
		
	}

}
