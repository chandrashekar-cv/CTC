package grpahsNtrees;

import java.util.ArrayList;
import java.util.List;

public class MinimumDiffBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getMinimumDifference(TreeNode root) {
		int min = Integer.MAX_VALUE;
		
		List<Integer> values = inorder(root);
		
		
		for(int i=0;i<values.size()-1;i++)
			min = Math.min(min,Math.abs(values.get(i)-values.get(i+1)));
		
		return min;
        
    }
	public List<Integer> inorder(TreeNode node) {
		
		List<Integer> values = new ArrayList<>();
		
		if(node.left!=null) {
			values.addAll(inorder(node.left));
		}
		values.add(node.val);
		
		if(node.right!=null)
			values.addAll(inorder(node.right));
		
		
		return values;
	}
	
	

}
