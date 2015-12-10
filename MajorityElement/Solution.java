public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for(int i: nums) {
            if(count == 0 || i == result) {
                result = i;
                ++ count;
            } else {
                --count;
            }
        }
        return result;
    }
}
