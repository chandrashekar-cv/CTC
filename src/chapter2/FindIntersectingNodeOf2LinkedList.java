package chapter2;

public class FindIntersectingNodeOf2LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
		
		if(headA == null || headB==null)
			return null;
		
		int lenA = 1;
		int lenB = 1;
		
		LinkedListNode runA = headA;
		LinkedListNode runB = headB;
		
		while(runA.next!=null && runB.next!=null) {
			if(runA==runB)
				return runA;
			runA = runA.next;
			runB = runB.next;
			lenA++;
			lenB++;
		}
		
		while(runA.next!=null) {
			runA=runA.next;
			lenA++;
		}
		
		while(runB.next!=null) {
			runB = runB.next;
			lenB++;
		}
		
		if(runA!=runB)
			return null;
		
		if(lenA>lenB)
			headA = fastforward(headA, lenA-lenB);
		else
			headB = fastforward(headB, lenB-lenA);
		
		while(headA!=headB) {
			headA = headA.next;
			headB = headB.next;
		}
		
		return headA;
    }
	
	LinkedListNode fastforward(LinkedListNode node, int diff) {
		for(int i=0;i<diff;i++)
			node = node.next;
		
		return node;
	}

}
