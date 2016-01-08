public class Solution {
    public int[] singleNumber(int[] nums) {
        int n1 = 0, n2 = 0, diff = 0, firstDifferentBit = 0;
        for(int i: nums) {
            diff ^= i;
        }
        firstDifferentBit = diff & -diff;
        for(int i: nums) {
            if( (i & firstDifferentBit) == 0 ) {
                n1 ^= i;
            } else {
                n2 ^= i;
            }
        }
        return new int[]{n1, n2};
    }
}
