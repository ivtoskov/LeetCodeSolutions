public class Solution {
    public int[] countBits(int num) {
        if(num < 1) {
            return new int[] {0};
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        
        int stride = 2, index = 2;
        while(index <= num) {
            for(int i = 0; i < stride && index <= num; ++i) {
                result[index] = 1 + result[index - stride];
                ++index;
            }
            stride *= 2;
        }
        
        return result;
    }
}
