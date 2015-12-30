public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while(n-- > 1) {
            StringBuilder sb = new StringBuilder();
            char current = s.charAt(0);
            int count = 1;
            for(int i = 1; i < s.length(); ++i) {
                if(current == s.charAt(i)) {
                    ++count;
                } else {
                    sb.append(count);
                    sb.append(current);
                    count = 1;
                    current = s.charAt(i);
                }
            }
            sb.append(count);
            sb.append(current);
            s = sb.toString();
        }
        return s;
    }
}
