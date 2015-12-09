public class Solution {
    public int addDigits(int num) {
        while(num >= 10) {
            int current;
            int value = 0;
            while(num > 0) {
                current = num % 10;
                num /= 10;
                value += current;
            }
            num = value;
        }
        return num;
    }
}
