public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        levelOrder(root, 0, result);
        return result;
    }
    
    private void levelOrder(TreeNode node, int index, List<List<Integer>> result) {
        if(node != null) {
            if(index >= result.size()) {
                List<Integer> level = new ArrayList<>();
                result.add(level);
            }
            List<Integer> current = result.get(index);
            current.add(node.val);
            levelOrder(node.left, index + 1, result);
            levelOrder(node.right, index + 1, result);
        }
    }
}
