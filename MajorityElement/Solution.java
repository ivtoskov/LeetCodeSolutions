public class Solution {
    public int majorityElement(int[] nums) {
        java.util.Map<Integer, Integer> counts = new java.util.HashMap<>();
        for(int i: nums) {
            Integer current = counts.get(i);
            if(current == null) current = 0;
            if(current + 1 > nums.length / 2) return i;
            counts.put(i, current + 1);
        }
        return -1;
    }
}
