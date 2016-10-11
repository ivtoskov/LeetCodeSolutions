public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head.next;
        while (current != null) {
            insert(head, current);
            current = current.next;
        }
        return head;
    }
    
    private void insert(ListNode head, ListNode current) {
        int val = current.val;
        while (head != current) {
            if (current.val < head.val) {
                int tmp = head.val;
                head.val = current.val;
                current.val = tmp;
            }
            head = head.next;
        }
    }
}
