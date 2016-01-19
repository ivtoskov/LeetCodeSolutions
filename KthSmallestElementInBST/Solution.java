public class Solution {
    int current = 0;
    int temp = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        current = 0;
        dfs(root, k);
        return temp;
    }
    
    private void dfs(TreeNode node, int k) {
        if(node == null || current > k) return;
        dfs(node.left, k);
        if(++current == k) {
            temp = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
