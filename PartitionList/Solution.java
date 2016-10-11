public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftBegin = null, leftEnd = null, rightBegin = null, rightEnd = null;
        
        while (head != null) {
            if (head.val < x) {
                if (leftBegin == null) {
                    leftBegin = leftEnd = head;
                } else {
                    leftEnd.next = head;
                    leftEnd = head;
                }
            } else {
                if (rightBegin == null) {
                    rightBegin = rightEnd = head;
                } else {
                    rightEnd.next = head;
                    rightEnd = head;
                }
            }
            head = head.next;
        }
        
        if (leftEnd != null) {
            leftEnd.next = rightBegin;
        }
        
        if (rightEnd != null) {
            rightEnd.next = null;
        }
        
        return (leftBegin != null) ? leftBegin : rightBegin;
    }
}
