public class Solution {
    public int lengthLongestPath(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        Token[] tokens = getTokens(input.split("\n"));
        Stack<Token> stack = new Stack<>();
        int maxLength = 0;
        for (Token token : tokens) {
            while (!stack.empty() && stack.peek().level >= token.level) {
                stack.pop();
            }
            int prevLength = stack.empty() ? 0 : stack.peek().cumLength;
            if (token.isFile) {
                maxLength = Math.max(maxLength, prevLength + token.length + token.level);
            } else {
                token.cumLength = prevLength + token.length;
                stack.push(token);
            }
        }
        
        return maxLength;
    }
    
    private Token[] getTokens(String[] strTokens) {
        Token[] tokens = new Token[strTokens.length];
        for (int i = 0; i < strTokens.length; ++i) {
            String strToken = strTokens[i];
            int index = 0;
            while (index < strToken.length() && strToken.charAt(index) == '\t') {
                index++;
            }
            int length = strToken.length() - index, level = index;
            boolean isFile = false;
            while (index < strToken.length()) {
                if (strToken.charAt(index) == '.' && index + 1 < strToken.length()) {
                    isFile = true;
                    break;
                }
                ++index;
            }
            tokens[i] = new Token(length, level, isFile);
        }
        return tokens;
    }
    
    private class Token {
        final int length;
        final int level;
        final boolean isFile;
        int cumLength;
        
        Token(int length, int level, boolean isFile) {
            this.length = length;
            this.level = level;
            this.isFile = isFile;
            this.cumLength = 0;
        }
        
        @Override
        public String toString() {
            return String.format("[len = %d, lev = %d, %s]", length, level, (isFile) ? "file" : "dir");
        }
    }
}
