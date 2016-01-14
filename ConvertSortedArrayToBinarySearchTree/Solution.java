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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int midIndex = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST(nums, left, midIndex - 1);
        root.right = sortedArrayToBST(nums, midIndex + 1, right);
        return root;
    }
}
