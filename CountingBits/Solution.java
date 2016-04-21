public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        
        int stride = 1, index = 1;
        while(index <= num) {
            for(int i = 0; i < stride && index <= num; ++i) {
                result[index] = 1 + result[index - stride];
                ++index;
            }
            stride <<= 1;
        }
        
        return result;
    }
}
