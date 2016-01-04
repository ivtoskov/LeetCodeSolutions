public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        for(; n > 0; n /= 26) {
            sb.insert(0, (char) ((--n % 26) + 'A'));
        }
        return sb.toString();
    }
}
