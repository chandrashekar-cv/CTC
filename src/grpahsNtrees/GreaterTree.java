package grpahsNtrees;

public class GreaterTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode convertBST(TreeNode root) {
		
        return root;
    }
	
	public int traverse(TreeNode node, int parentScore, boolean left) {
		
		
		if(node.left == null && node.right == null)
			return node.val;
		
		int sum = 0;
		int rightSum = 0;
		int leftSum = 0;
		int rootSum =0;
		
		if(node.right!=null)
			rightSum = traverse(node.right,0,false);
		
		sum = node.val + rightSum;
		
		node.val = sum;
		
		if(node.left!=null)
			return 1;
			//leftSum = traverse(node.left, sum);
			
		
		
		
		
		return sum;
		
	}

}
