public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[words.length];
        int[] lengths = new int[words.length];
        for(int i = 0; i < n; ++i) {
            int currentLength = words[i].length();
            lengths[i] = currentLength;
            String s = words[i];
            for(int j = 0; j < currentLength; ++j) {
                int p = (int) (s.charAt(j) - 'a');
                p = 1 << p;
                masks[i] = masks[i] | p;
            }
        }
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if((masks[i] & masks[j]) == 0) {
                    int product = lengths[i] * lengths[j];
                    if(max < product) {
                        max = product;
                    }
                }
            }
        }
        return max;
    }
}
