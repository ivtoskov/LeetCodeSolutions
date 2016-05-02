public class Solution {
    private class MinMax {
        int min, max;
        private MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    
    public int rob(TreeNode root) {
        MinMax res = robmm(root);
        return Math.max(res.min, res.max);
    }
    
    private MinMax robmm(TreeNode root) {
        MinMax result = new MinMax(0, 0);
        if(root == null) {
            return result;
        }
        MinMax left = robmm(root.left); 
        MinMax right = robmm(root.right);
        
        result.min = left.max + right.max;
        result.max = Math.max(result.min, root.val + left.min + right.min);
        return result;
    }
}
