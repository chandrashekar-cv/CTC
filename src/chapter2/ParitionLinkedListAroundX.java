package chapter2;

public class ParitionLinkedListAroundX {

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
		
		LinkedListNode res = partition(top,12);
		System.out.println();
		while(res!=null) {
			System.out.print(String.valueOf(res.data)+" ");
			res=res.next;
		}
	}
	
	public static LinkedListNode partition(LinkedListNode node, int k) {
		if(node == null)
			return null;
		
		LinkedListNode head = node;
		LinkedListNode tail = node;
		LinkedListNode runner = node;
		while(runner !=null) {
			LinkedListNode nextNode = runner.next;
			if(runner.data < k) {
				runner.next = head;
				head = runner;
			}
			else {
				tail.next = runner;
				tail = tail.next;
				
			}
			runner = nextNode;
		}
		tail.next = null;
		return head;
		
	}


}
