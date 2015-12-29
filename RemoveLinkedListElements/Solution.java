public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next;
        if(head == null) return null;
        ListNode n = head;
        while(n != null) {
            while(n.next != null && n.next.val == val) n.next = n.next.next;
            n = n.next;
        }
        return head.val != val ? head : head.next;
    }
}
