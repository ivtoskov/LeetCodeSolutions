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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode node, int prev) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return prev + node.val;
        }
        prev = (node.val + prev) * 10;
        return sumNumbers(node.left, prev) + sumNumbers(node.right, prev);
    }
}
