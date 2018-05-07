package chapter2;

public class SortLinkedList {

	public static void main(String[] args) {
		SortLinkedList sol = new SortLinkedList();
		
		ListNode root = new ListNode(4);
		ListNode a = new ListNode(2);
		root.next = a;
		ListNode b = new ListNode(1);
		a.next=b;
		ListNode c = new ListNode(3);
		b.next=c;
		ListNode sort = sol.sortList(root);
		
		while(sort!=null) {
			System.out.println(sort.val);
			sort = sort.next;
		}

	}
    public ListNode sortList(ListNode head) {
     
    	if(head == null || head.next==null)
    		return head;
    	if(head.next.next==null) {
    		ListNode prev = head;
    		ListNode next = head.next;
    		if(prev.val>next.val) {
    			int temp = prev.val;
    			prev.val = next.val;
    			next.val = temp;
    			
    		}
    		return prev;
    		
    	}
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode prev = null;
    	while(fast!=null && fast.next!=null) {
    		prev=slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	prev.next = null;
    	ListNode left = sortList(head);
    	ListNode right = sortList(slow);
    	
    	return mergeList(left, right);
    	
    }
    
    public ListNode mergeList(ListNode left, ListNode right) {
    	ListNode root = new ListNode(0);
    	ListNode next = root;
    	
    	while(left!=null && right !=null) {
    		if(left.val < right.val) {
    			next.next = left;
    			next = next.next;
    			left = left.next;
    		}
    		else {
    			next.next = right;
    			next = next.next;
    			right = right.next;
    		}
    	}
    	
    	ListNode remaining = left==null? right: left;
    	
    	while(remaining !=null) {
    		next.next = remaining;
    		next = next.next;
    		remaining = remaining.next;
    	}
    	
    	return root.next;
    }
}
