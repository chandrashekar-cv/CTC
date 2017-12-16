package chapter2;

public class Add2NumbersRepresentedInLinkedList {

	public static void main(String[] args) {
		LinkedListNode a =new LinkedListNode(2);
		System.out.print(String.valueOf(a.data)+" ");
		LinkedListNode prev1 = a;
		
		for(int i=0;i<3;i++) {
			LinkedListNode data = new LinkedListNode((int) ((Math.random()*100)%10));
			System.out.print(String.valueOf(data.data)+" ");
			prev1.next = data;
			prev1 = prev1.next;
		}
		
		System.out.println();
		LinkedListNode b =new LinkedListNode(2);
		System.out.print(String.valueOf(b.data)+" ");
		LinkedListNode prev2 = b;
		
		for(int i=0;i<4;i++) {
			LinkedListNode data = new LinkedListNode((int) ((Math.random()*100)%10));
			System.out.print(String.valueOf(data.data)+" ");
			prev2.next = data;
			prev2 = prev2.next;
		}
		
		System.out.println();
		
		LinkedListNode res = addList(a, b);
		
		while(res!=null) {
			System.out.print(String.valueOf(res.data)+" ");
			res = res.next;
		}
		
		
		

	}
	
	public static LinkedListNode addList(LinkedListNode a, LinkedListNode b) {
		LinkedListNode result = new LinkedListNode(0);
		LinkedListNode prev = result;
		if(a==null && b==null)
			return new LinkedListNode(0);
		if(a==null)
			return b;
		if(b==null)
			return a;
		
		int carry = 0;
		
		while(a!=null && b!=null) {
			int localSum = a.data+b.data+carry;
			carry = localSum/10;
			
			LinkedListNode cur = new LinkedListNode((localSum%10));
			prev.next = cur;
			prev = prev.next;
			
			a=a.next;
			b=b.next;
		}
		
		
		if(a!=null || b!=null) {
			LinkedListNode rest = null;
			if(a==null)
				rest= b;
			else
				rest=a;
			
			while(rest!=null) {
				int localSum = rest.data+carry;
				carry = localSum/10;
				
				LinkedListNode cur = new LinkedListNode((localSum%10));
				prev.next = cur;
				prev = prev.next;
				
				rest = rest.next;
			}
		
		}
		
		if(carry>0)
			prev.next = new LinkedListNode(carry);
		return result.next;
		
	}

}
