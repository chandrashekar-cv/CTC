package chapter2;
/*
 * Delete Middle Node: Implement an algorithm to delete a node in the middle 
 * (Le., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 */


public class DeleteMiddleNodeInList {

	public static void main(String[] args) {
		LinkedListNode top =new LinkedListNode(12);
		System.out.print(String.valueOf(top.data)+" ");
		LinkedListNode prev = top;
		
		
		for(int i=0;i<8;i++) {
			LinkedListNode data = new LinkedListNode((int) ((Math.random()*100)%28));
			System.out.print(String.valueOf(data.data)+" ");
			prev.next = data;
			prev = prev.next;
		}
		
		deleteMiddleNode(top);
		
		System.out.println("result");
		while(top!=null) {
			System.out.print(String.valueOf(top.data)+" ");
			top = top.next;
		}

	}
	
	public static void deleteMiddleNode(LinkedListNode node) {
		
		if(node == null || node.next==null || node.next.next==null)
			return;
		
		LinkedListNode dummyTop = new LinkedListNode(0);
		dummyTop.next = node;
		
		LinkedListNode runner = dummyTop;
		LinkedListNode skipper = dummyTop.next;
		
		while(skipper!=null && skipper.next!=null) {
			runner = runner.next;
			skipper = skipper.next.next;
		}
		
		LinkedListNode delNode = runner.next;
		runner.next = runner.next.next;
		System.out.println("deletedNode = "+String.valueOf(delNode.data));
	}
	

}
