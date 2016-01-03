public class OptimizedSolution {
    public String convert(String s, int numRows) {
        if(numRows < 2 || s.length() < numRows) return s;
        char[] converted = new char[s.length()];
        char[] ss = s.toCharArray();
        int step = (numRows - 1) << 1, index = 0;
        for(int i = 0; i < s.length(); i += step) converted[index++] = ss[i];
        for(int i = 1; i < numRows - 1; ++i) {
            int j = i, addChar = step - i;
            while(j + step < s.length()) {
                converted[index++] = ss[j];
                converted[index++] = ss[addChar];
                j += step; addChar += step;
            }
            converted[index++] = ss[j];
            if(addChar < s.length()) converted[index++] = ss[addChar];
        }
        for(int i = numRows - 1; i < s.length(); i += step) converted[index++] = ss[i];
        return new String(converted);
    }
}
