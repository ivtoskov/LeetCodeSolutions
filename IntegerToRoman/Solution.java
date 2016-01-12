public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder(9);
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        for(int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            while(num >= current) {
                num -= current;
                sb.append(romans[i]);
                if(num == 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
