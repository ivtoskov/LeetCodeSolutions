public class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2 || s.length() < numRows) return s;
        char[] converted = new char[s.length()];
        int step = (numRows - 2) * 2 + 2, index = 0;
        for(int i = 0; i <= numRows - 1; ++i) {
            for(int j = i; j < s.length(); j += step) {
                converted[index++] = s.charAt(j);
                int addChar = j + step - i * 2;
                if(i % (numRows - 1) != 0 && addChar < s.length()) converted[index++] = s.charAt(addChar);
            }
        }
        return new String(converted);
    }
}
