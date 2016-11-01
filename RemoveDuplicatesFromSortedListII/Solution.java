/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode start = new ListNode(head.val - 1);
        start.next = head;
        ListNode added = start, current = head;
        
        while (current != null) {
            added.next = null;
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                
                current = current.next;
            } else {
                added.next = current;
                added = current;
                current = current.next;
            }
        }
        
        return start.next;
    }
}
