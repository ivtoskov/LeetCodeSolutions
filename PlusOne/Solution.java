public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[0];
        
        for(int i = digits.length - 1; i >= 0; --i) {
            ++digits[i];
            if(digits[i] == 10) {
                digits[i] = 0;
            } else {
                break;
            }
        }
        
        if(digits[0] == 0) {
            int[] answer = new int[digits.length + 1];
            System.arraycopy(digits, 0, answer, 1, digits.length);
            answer[0] = 1;
            return answer;
        }
        return digits;
    }
}
