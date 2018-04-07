package arrays;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator implements Iterator<NestedInteger>{

	Stack<NestedInteger> flatList = new Stack<NestedInteger>();
	
	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		for(int i=nestedList.size()-1;i>=0;i--)
			flatList.push(nestedList.get(i));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public NestedInteger next() {
		return flatList.pop().getInteger();
		
	}
	
	@Override
	public boolean hasNext() {
		while(!flatList.isEmpty()) {
			NestedInteger top = flatList.peek();
			if(top.isInteger())
				return true;
			flatList.pop();
			
			for(int i=top.getList().size()-1;i>=0;i--) {
				flatList.push(top.getList().get(i));
			}
			
		}
		return false;
	}

	
	
	

}
