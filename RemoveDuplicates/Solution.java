public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;
        while(first != null) {
            while(first.next != null && first.next.val == first.val) {
                first.next = first.next.next;
            }
            first = first.next;
        }
        return head;
    }
}
