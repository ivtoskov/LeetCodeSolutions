public class Solution {
    private int in;
    private int post;
    private int[] inorder;
    private int[] postorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = post = inorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        return buildTree(null);
    }
    
    private TreeNode buildTree(TreeNode end) {
        if (post < 0) {
            return null;
        }
        
        TreeNode current = new TreeNode(postorder[post--]);
        
        if (current.val != inorder[in]) {
            current.right = buildTree(current);
        }
        
        in--;
        
        if (end == null || end.val != inorder[in]) {
            current.left = buildTree(end);
        }
        
        return current;
    }
}
