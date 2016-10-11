public class Solution {
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        return sortedListToBST(0, length(head) - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode head = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        
        head.left = left;
        head.right = right;
        return head;
    }
    
    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
