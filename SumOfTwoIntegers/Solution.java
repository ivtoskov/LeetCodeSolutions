public class Solution {
    public int getSum(int a, int b) {
        int carry = 0, result = 0, mask = 1, helper = 0;
        for(int i = 0; i < 32; ++i) {
            int op1 = a & 1, op2 = b & 1;
            helper = op1 + op2 + carry;
            if(helper % 2 == 1) {
                result |= mask;
            }
            if(helper > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            a >>= 1;
            b >>= 1;
            mask <<= 1;
        }
        return result;
    }
}
