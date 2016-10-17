public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        Map<String, Integer> imap = new HashMap<>();
        Map<String, Integer> rmap = new HashMap<>();
        String[] revWords = new String[n];
        for (int i = 0; i < n; ++i) {
            String current = words[i];
            String rev = new StringBuilder(current).reverse().toString();
            imap.put(current, i);
            rmap.put(rev, i);
            revWords[i] = rev;
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(helper(rmap, words, false));
        result.addAll(helper(imap, revWords, true));
        return result;
    }
    
    private List<List<Integer>> helper(Map<String, Integer> imap, String[] words, boolean reverse) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String current = words[i];
            for (int j = reverse ? 1 : 0; j <= current.length(); ++j) {
                Integer opp = imap.get(current.substring(j));
                if (opp != null && opp != i) {
                    if (isPalRegion(current, 0, j - 1)) {
                        result.add(reverse ? Arrays.asList(i, opp) : Arrays.asList(opp, i));
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalRegion(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;    
            }
        }
        return true;
    }
}
