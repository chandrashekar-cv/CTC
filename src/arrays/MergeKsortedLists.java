package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	 public ListNode mergeKLists(ListNode[] lists) {
		 ListNode root = new ListNode(0);
		 ListNode insertPos = root;
		 
		 //Max Heap by priority queue 
		 PriorityQueue<ListNode> kSizeHeap = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode node1, ListNode node2) {
				
				return node1.val-node2.val;
			}
			
		 });

		 //Add the first element from each list in lists 
		 for(ListNode listTop: lists) {
			 if(listTop !=null) {
				 kSizeHeap.add(listTop);
				 listTop = listTop.next;
			 }
		 }
		 
		 
		 while(!kSizeHeap.isEmpty()){
			 //Get peek node from heap
			 ListNode nextNode = kSizeHeap.poll();
			 insertPos.next = nextNode;
			 insertPos = insertPos.next;
			 
			 //Get the next node from list to which the popped node belongs. 
			 ListNode topNode = nextNode.next;
			 ListNode nextElementFromList = topNode.next;
			 if(nextElementFromList !=null)
				 kSizeHeap.add(nextElementFromList);
			 
		 }	 
		 return root.next;
	 }
	 
	 

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
