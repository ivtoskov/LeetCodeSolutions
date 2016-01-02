public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next.next;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next == null ? fast.next : fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        fast = head;
        while(rev != null) {
            if(fast.val != rev.val) return false;
            fast = fast.next;
            rev = rev.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = null;
        while(n != null) {
            ListNode nn = n.next;
            n.next = head;
            head = n;
            n = nn;
        }
        return head;
    }
}
