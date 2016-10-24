public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, 0, sum, new ArrayList<>(), result);
        return result;
    }
    
    private void pathSum(TreeNode node, int prev, int sum, List<Integer> buffer, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        buffer.add(node.val);
        if (node.val + prev == sum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(buffer));
        }
        
        pathSum(node.left, prev + node.val, sum, buffer, result);
        pathSum(node.right, prev + node.val, sum, buffer, result);
        buffer.remove(buffer.size() - 1);
    }
}
