public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        int size = maxDepth(root);
        List<List<Integer>> result = new ArrayList<>(size);
        for(int i = 0; i < size; ++i) {
            result.add(new ArrayList<>());
        }
        levelOrderBottom(root, result, size - 1);
        return result;
    }
    
    private void levelOrderBottom(TreeNode root, List<List<Integer>> result, int index) {
        if(index >= 0 && root != null) {
            result.get(index).add(root.val);
            levelOrderBottom(root.left, result, index - 1);
            levelOrderBottom(root.right, result, index - 1);
        }
    }
    
    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
