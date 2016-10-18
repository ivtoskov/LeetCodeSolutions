public class Solution {
    int globalMax;
    
    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        helper(root);
        return globalMax;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        globalMax = Math.max(globalMax, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
