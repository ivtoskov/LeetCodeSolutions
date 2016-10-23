public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int findSum(TreeNode node, int sum) {
        return node == null ? 0 : ((node.val == sum ? 1 : 0) + findSum(node.left, sum - node.val) + findSum(node.right, sum - node.val));
    }
}
