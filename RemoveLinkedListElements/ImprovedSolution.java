public class ImprovedSolution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next;
        if(head == null) return null;
        ListNode n = head;
        while(n.next != null) {
            if(n.next.val == val) n.next = n.next.next;
            else n = n.next;
        }
        return head.val != val ? head : head.next;
    }
}
