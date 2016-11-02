public class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = 0, num = 0, sign = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i + 1 < s.length() && !Character.isDigit(s.charAt(i + 1))) {
                    stack.peek().add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                }
            } else if (c == '-') {
                sign = -1;
            } else if (c == '[') {
                stack.push(new NestedInteger());
            } else if (c == ']') {
                NestedInteger current = stack.pop();
                if (stack.isEmpty()) {
                    return current;
                } else {
                    stack.peek().add(current);
                }
            }
        }
        
        return s.isEmpty() ? new NestedInteger() : new NestedInteger(Integer.parseInt(s));
    }
}
