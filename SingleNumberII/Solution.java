public class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num: nums) {
            for(int i = 0; i < 32; ++i) {
                if((num & (1 << i)) != 0) {
                    counts[i]++;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < 32; ++i) {
            if(counts[i] % 3 != 0) {
                answer |= (1 << i);
            }
        }
        return answer;
    }
}
