public class Solution {
    public int lastRemaining(int n) {
        int rem = n, head = 1, step = 1;
        boolean isLeft = true;
        while (rem > 1) {
            if (isLeft || (rem & 1) == 1) {
                head += step;
            }
            step <<= 1;
            rem >>= 1;
            isLeft = !isLeft;
        }
        return head;
    }
}
