package grpahsNtrees;

public class MinimalTree {

	public static void main(String[] args) {
		MinimalTree sol = new MinimalTree();
		TreeNode res = sol.sortedArrayToBST(new int[] {-10,-3,0,5,9});
		
		System.out.println(res.val);

	}
	
	 public TreeNode sortedArrayToBST(int[] nums) {
		 if(nums==null)
			 return null;
		 if(nums.length==1)
			 return new TreeNode(nums[0]);
		 
		 TreeNode result = buildTree(0, nums.length-1, nums);
		 return result;
	 }
	 
	 public TreeNode buildTree(int left,int right,int[]nums) {
		 if(left>right)
			 return null;
		 if(left == right)
			 return new TreeNode(nums[left]);
		 
		 int mid = (left+right+1)/2;
		 
		 TreeNode root = new TreeNode(nums[mid]);
		 root.left =  buildTree(left, mid-1, nums);
		 root.right = buildTree(mid+1,right,nums);
		 
		 return root;
	 }

}
