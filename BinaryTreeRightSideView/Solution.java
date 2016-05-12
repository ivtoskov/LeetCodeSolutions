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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, 0, -1, result);
        return result;
    }
    
    private int rightSideView(TreeNode node, int currentLevel, int maxLevel, List<Integer> result) {
        if(node == null) {
            return maxLevel;
        }
        
        if(currentLevel > maxLevel) {
            maxLevel = currentLevel;
            result.add(node.val);
        }
        
        maxLevel = rightSideView(node.right, currentLevel + 1, maxLevel, result);
        int lMax = rightSideView(node.left, currentLevel + 1, maxLevel, result);
        maxLevel = (maxLevel > lMax) ? maxLevel : lMax;
        
        return maxLevel;
    }
}
