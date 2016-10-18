public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1, tmp = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
                continue;
            } 
            
            res += sign * tmp;
            tmp = 0;
            
            if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res + sign * tmp;
    }
}
