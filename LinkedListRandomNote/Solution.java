/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    Random rgen;
    List<Integer> values;
    int size;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        rgen = new Random();
        size = values.size();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return values.get(rgen.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
