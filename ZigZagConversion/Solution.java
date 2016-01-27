public class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2 || s.length() < numRows) return s;
        char[] converted = new char[s.length()];
        int index = 0, step = (numRows - 1) << 1;
        for(int i = 0; i <= numRows - 1; ++i) {
            for(int j = i, addChar = step - i; j < s.length(); j += step, addChar += step) {
                converted[index++] = s.charAt(j);
                if(i % (numRows - 1) != 0 && addChar < s.length()) converted[index++] = s.charAt(addChar);
            }
        }
        return new String(converted);
    }
}
