public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head.next, first = head, second = head.next, third = head.next.next;
        while(first != null && second != null) {
            second.next = first;
            first.next = (third == null || third.next == null) ? third : third.next;
            first = third;
            if(first != null) {
                second = first.next;
                if(second != null) {
                    third = second.next;
                }
            }
        }
        
        return newHead;
    }
}
