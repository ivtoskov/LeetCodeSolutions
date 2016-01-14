public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current = root, left;
        while(current != null && current.left != null) {
            left = current.left;
            while(current != null) {
                current.left.next = current.right;
                current.right.next = (current.next == null) ? null : current.next.left;
                current = current.next;
            }
            current = left;
        }
    }
}
