public class Solution {
    public int reverseBits(int n) {
        int mask = Integer.MIN_VALUE;
        int rmask = 1;
        int answer = 0;
        while(mask != 0) {
            if((mask & n) != 0) {
                answer |= rmask;
            }
            mask >>>= 1;
            rmask <<= 1;
        }
        return answer;
    }
}
