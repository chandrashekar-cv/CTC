package chapter2;

/*
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */

public class ReturnKthLastElement {

	public static void main(String[] args) {
		LinkedListNode top =new LinkedListNode(12);
		System.out.print(String.valueOf(top.data)+" ");
		LinkedListNode prev = top;
		
		
		for(int i=0;i<10;i++) {
			LinkedListNode data = new LinkedListNode((int) ((Math.random()*100)%28));
			System.out.print(String.valueOf(data.data)+" ");
			prev.next = data;
			prev = prev.next;
		}
		System.out.println();
		LinkedListNode res = ReturnKthLastElement.kthLastElement(top, 1);
		if(res == null)
			System.out.println("None");
		else System.out.println(res.data);
		
	}
	
	public static LinkedListNode kthLastElement(LinkedListNode node, int k) {
		if(node == null)
			return node;
		
		if(k<0)
			return null;
		
		LinkedListNode runner = node;
		
		int i;
		for(i=1;i<=k;i++) {
			runner = runner.next;
			if(runner==null)
				break;
		}
		
		if(i<k)
			return null;
		
		LinkedListNode res = node;
		
		while(runner!=null) {
			res = res.next;
			runner = runner.next;
		}
		
		return res;
		
	}

}
