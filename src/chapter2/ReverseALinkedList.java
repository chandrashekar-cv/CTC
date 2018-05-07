package chapter2;

public class ReverseALinkedList {

	public static void main(String[] args) {
		ListNode root = new ListNode(2);
		root.next = new ListNode(1);
		
		ReverseALinkedList sol = new ReverseALinkedList();
		ListNode res = sol.reverseList(root);
		
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}

	}
	public ListNode reverseList(ListNode head) {
		
		if(head==null)
			return head;
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = cur.next;
		while(cur!=null) {
			
			cur.next = prev;
			prev = cur;
			cur = next;
			if(next!=null)
				next = next.next;
			
		}
		
		return prev;
    }
}
