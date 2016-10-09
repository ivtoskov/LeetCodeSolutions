public class Solution {
    public String addStrings(String num1, String num2) {
        int maxLen = Math.max(num1.length(), num2.length());
        char[] chars = new char[maxLen + 1];
        chars[0] = '0';
        int ind1 = num1.length() - 1, ind2 = num2.length() - 1, carry = 0, value = 0, ind = chars.length - 1;
        
        while (ind1 >= 0 || ind2 >= 0 || carry > 0) {
            int op1 = ind1 >= 0 ? num1.charAt(ind1) - '0' : 0;
            int op2 = ind2 >= 0 ? num2.charAt(ind2) - '0' : 0;
            value = (op1 + op2 + carry) % 10;
            carry = (op1 + op2 + carry) / 10;
            
            chars[ind] = (char) (value + '0');
            
            ind--;
            ind1--;
            ind2--;
        }
        
        String res = new String(chars);
        return res.charAt(0) == '0' ? res.substring(1) : res;
    }
}
