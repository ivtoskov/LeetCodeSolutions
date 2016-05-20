/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head, even = head.next, evenHead = head.next, next = head.next.next;
        while(next != null) {
            odd.next = next;
            even.next = next.next;
            odd = odd.next;
            even = even.next;
            
            if(next.next != null) {
                next = next.next.next;
            } else {
                next = next.next;
            }
        }
        odd.next = evenHead;
        
        return head;
    }
}
