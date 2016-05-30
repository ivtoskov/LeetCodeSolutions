public class Solution {
    public boolean isHappy(int n) {
        while(true) {
            if(n < 10) {
			       break;
            }
            int newn = 0;
            while(n != 0) {
                int digit = n % 10;
                n /= 10;
                newn += digit * digit;
            }
            n = newn;
        }
        return (n == 1) || (n == 7);
    }
}
