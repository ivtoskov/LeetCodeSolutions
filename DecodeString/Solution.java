public class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        int currentInt = 0;
        StringBuilder currentSb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentInt = currentInt * 10 + c - '0';
            } else if (c == '[') {
                intStack.push(currentInt);
                sbStack.push(currentSb);
                currentInt = 0;
                currentSb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = currentSb;
                currentSb = sbStack.pop();
                for (int i = intStack.pop(); i > 0; --i) {
                    currentSb.append(tmp);
                }
            } else {
                currentSb.append(c);
            }
        }
        return currentSb.toString();
    }
}
