package binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import grpahsNtrees.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False*/

public class TwoSum_IV_BST {

	public static void main(String[] args) {
		
		
		String x = "asdfgh";
		StringBuilder builder = new StringBuilder();
		
		builder.append(x.toCharArray());
		
		for(int i=0;i<x.length();i++) {
			
			System.out.println(builder.subSequence(0, i).toString()+builder.subSequence(i+1, x.length()).toString());
		}

	}
	
	public boolean findTarget(TreeNode root, int target) {
        if(root==null)
            return false;
        List<Integer> values = new ArrayList<Integer>();
        
        inorder(root,values);
        int left = 0;
		int right = values.size()-1;
		
		while(left<right) {
			int sum = values.get(left)+values.get(right);
			if(target==sum)
				return true;
			
			if(sum>target)
				right--;
			else
				left++;
		}
		return false;
        
        
    }
    
    public void inorder(TreeNode node, List<Integer> values){
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    
    	
        if(node == null)
            return;
        inorder(node.left,values);
        values.add(node.val);
        inorder(node.right,values);
        
    }

}
