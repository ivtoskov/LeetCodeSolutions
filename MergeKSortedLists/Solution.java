public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (node1, node2) -> {return node1.val - node2.val;});
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            tail.next = next;
            if (next.next != null) {
                queue.add(next.next);
            }
            tail = tail.next;
        }
        
        return head.next;
    }
}
