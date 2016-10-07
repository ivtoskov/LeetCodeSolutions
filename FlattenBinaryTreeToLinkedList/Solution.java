public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pred = root.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
