/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = length(head);
        int count = len - (k % len) - 1;
        ListNode cur = head;
        
        while (count-- > 0) {
            cur = cur.next;
        }
        
        ListNode secondHead = reverse(cur.next);
        cur.next = null;
        ListNode realHead = reverse(head);
        head.next = secondHead;
        return reverse(realHead);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
