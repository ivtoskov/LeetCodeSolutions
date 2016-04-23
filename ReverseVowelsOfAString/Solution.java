public class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'o' || c == 'u' || c == 'e' || c == 'i' ||
               c == 'A' || c == 'O' || c == 'U' || c == 'E' || c == 'I';
    }
    
    public String reverseVowels(String s) {
        int n = s.length();
        char[] revChars = new char[n];
        for(int i = 0, j = n - 1; i <= j; ++i, --j) {
            while(i < j && !isVowel(s.charAt(i))) {
                revChars[i] = s.charAt(i);
                ++i;
            }
            while(i < j && !isVowel(s.charAt(j))) {
                revChars[j] = s.charAt(j);
                --j;
            }
            revChars[i] = s.charAt(j);
            revChars[j] = s.charAt(i);
        }
        return new String(revChars);
    }
}
