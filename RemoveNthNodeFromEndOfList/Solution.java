public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int rem = remaining(head, n);
        return rem == n ? head.next : head;
    }
    
    private int remaining(ListNode head, int n) {
        if(head == null) return 0;
        int rem = remaining(head.next, n);
        if(rem == n) {
            head.next = head.next.next;
        }
        return rem + 1;
    }
}
