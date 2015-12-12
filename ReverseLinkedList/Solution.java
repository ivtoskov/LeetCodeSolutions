public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = null;
        
        while(n.next != null) {
            ListNode nn = n.next;
            n.next = head;
            head = n;
            n = nn;
        }
        
        n.next = head;
        return n;
    }
}
