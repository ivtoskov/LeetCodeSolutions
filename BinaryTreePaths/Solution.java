public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if(root == null) return answer;
        if(root.left == null && root.right == null) {
            answer.add(String.valueOf(root.val));
        }
        List<String> left = binaryTreePaths(root.left);
        for(String s: left) {
            answer.add(root.val + "->" + s);
        }
        
        List<String> right = binaryTreePaths(root.right);
        for(String s: right) {
            answer.add(root.val + "->" + s);
        }
        
        return answer;
    }
}
