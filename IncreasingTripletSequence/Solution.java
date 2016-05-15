public class Solution {
    private int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    public boolean increasingTriplet(int[] nums) {
        for(int num: nums) {
            if(num > second) {
                return true;
            }
            second = (num > first) ? num : second;
            first = (num < first) ? num : first;
        }
        return false;
    }
}
