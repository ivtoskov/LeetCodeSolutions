public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        long sum = 0L;
        int sign = 1, i = 0;
        if(str.charAt(i) == '-') {
            sign = -1;
            ++i;
        } else if(str.charAt(i) == '+') {
            ++i;
        }
        while(i < str.length()) {
            int c = str.charAt(i);
            if(!Character.isDigit(c)) {
                break;
            }
            sum = sum * 10 + c - '0';
            if(sum * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(sum * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            ++i;
        }
        return (int) (sum * sign);
    }
}
