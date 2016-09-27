public class Solution {
    public int findNthDigit(int n) {
        int start = 1, len = 1;
        
        while (n > 9L * len * start) {
            n -= 9 * len * start;
            ++len;
            start *= 10;
        }
        
        n--;
        String number = String.valueOf(start + n / len);
        return number.charAt(n % len) - '0';
    }
}
