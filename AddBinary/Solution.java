public class Solution {
    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(indexA >= 0 || indexB >= 0) {
            int bitA = (indexA >= 0 ? a.charAt(indexA--) : '0') - '0';
            int bitB = (indexB >= 0 ? b.charAt(indexB--) : '0') - '0';
            sb.insert(0, (bitA + bitB + carry) % 2);
            carry = (bitA + bitB + carry) > 1 ? 1 : 0;
        }
        if(carry == 1) sb.insert(0, 1);
        return sb.toString();
    }
}
