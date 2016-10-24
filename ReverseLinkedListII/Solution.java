/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode last = null, cur = head, next, last2, prev = null;
        m = m - 1;
        n = n - m;
        
        while (m-- > 0) {
            last = cur;
            cur = cur.next;
        }
        
        last2 = cur;
        while (n-- > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        last2.next = cur;
        if (last == null) {
            return prev;
        } else {
            last.next = prev;
            return head;
        }
    }
}
