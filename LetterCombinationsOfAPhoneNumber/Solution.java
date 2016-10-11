public class Solution {
    private static char[][] map = {
      {},
      {},
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'},
      {'j', 'k', 'l'},
      {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'},
      {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'},
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        letterCombinations(digits.toCharArray(), 0, new char[digits.length()], result);
        return result;
    }
    
    private void letterCombinations(char[] digits, int index, char[] buffer, List<String> result) {
        if (index == digits.length) {
            result.add(new String(buffer));
            return;
        }
        
        char[] candidates = map[digits[index] - '0'];
        for (char c : candidates) {
            buffer[index] = c;
            letterCombinations(digits, index + 1, buffer, result);
        }
    }
}
