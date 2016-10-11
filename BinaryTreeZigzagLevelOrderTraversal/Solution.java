public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelTraversal(root, 0, result);
        for (int i = 1; i < result.size(); i += 2) {
            Collections.reverse(result.get(i));
        }
        return result;
    }
    
    private void levelTraversal(TreeNode current, int level, List<List<Integer>> result) {
        if (current == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(level).add(current.val);
        levelTraversal(current.left, level + 1, result);
        levelTraversal(current.right, level + 1, result);
    }
}
