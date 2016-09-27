/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int globalSum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        globalSum = 0;
        sumOfLeftLeaves(root, false);
        return globalSum;
    }
    
    private void sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        
        if (isLeft && isLeaf(node)) {
            globalSum += node.val;
            return;
        }
        
        sumOfLeftLeaves(node.left, true);
        sumOfLeftLeaves(node.right, false);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null & node.left == null & node.right == null;
    }
}
