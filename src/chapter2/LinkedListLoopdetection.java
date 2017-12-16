package chapter2;

public class LinkedListLoopdetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public LinkedListNode loopDetector(LinkedListNode head) {
		
		if(head == null)
			return null;
		
		
		LinkedListNode runner= head;
		LinkedListNode skipper = head;
		
		while(skipper!=null && skipper.next!=null) {
			
			runner = runner.next;
			skipper = skipper.next.next;
			
			if(runner==skipper)
				return getNode(head, runner);
			
		}
		
		return null;
	}
	
	LinkedListNode getNode(LinkedListNode head, LinkedListNode runner) {
		
		while(head!=runner) {
			head = head.next;
			runner = runner.next.next;
		}
		
		return runner;
		
	}

}
